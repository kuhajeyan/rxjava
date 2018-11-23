package com.samples.rx2java.core.errhandling;

import com.samples.rx2java.core.PrintSubscriber;

import io.reactivex.Observable;

/**
 * Resume another another sequence on error, The error will not appear in the
 * resulting observable.
 * 
 * @author kuhajeyan
 *
 */
public class OnErrorResumeNext {

	public static void main(String[] args) {
		Observable<Integer> values = Observable.create(o -> {
			o.onNext(1);
			o.onNext(2);
			o.onError(new Exception("Oops"));
			o.onNext(3);
			o.onNext(4);
			o.onNext(5);
			o.onNext(6);
		});

		values.onErrorResumeNext(Observable.just(Integer.MAX_VALUE)).subscribe(new PrintSubscriber("with onError: "));

	}

}
