package com.samples.rx2java.core.errhandling;

import java.util.Random;

import io.reactivex.Observable;

public class Retry {

	/**
	 * Our observable fails after two values, then tries again, fails again. The
	 * second time it fails the exception is allowed pass through
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random(100_000);
		Observable<Integer> values = Observable.create(o -> {
			o.onNext(random.nextInt() % 20);
			o.onNext(random.nextInt() % 50);

			o.onError(new Exception());

			o.onNext(random.nextInt() % 13);
			o.onNext(random.nextInt() % 12);
			o.onNext(random.nextInt() % 11);
			o.onNext(random.nextInt() % 9);
		});

		values.retry(1).subscribe(v -> System.out.println(v));

	}

}
