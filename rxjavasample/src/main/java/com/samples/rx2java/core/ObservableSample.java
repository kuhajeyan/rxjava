package com.samples.rx2java.core;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableSample {

	public static void main(String[] args) {

		Observable<Integer> source = Observable
				.fromIterable(IntStream.range(1, 10000).boxed().collect(Collectors.toList()));
		
		///sampling
		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(Integer t) {
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete() {
				System.out.println("Complete");
			}
		};
		source.sample(1, TimeUnit.MILLISECONDS).subscribe(observer);
		
		System.out.print("\n");;
		///throttling
		source.throttleFirst(1, TimeUnit.MILLISECONDS).subscribe(observer);
		
		//buffer
		source.buffer(10, TimeUnit.NANOSECONDS).subscribe(t -> System.out.println(t));
	}

}
