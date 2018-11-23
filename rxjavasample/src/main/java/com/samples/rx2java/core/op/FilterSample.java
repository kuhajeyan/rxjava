package com.samples.rx2java.core.op;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class FilterSample {

	public static void main(String[] args) {
		Observable<Integer> values = Observable.range(0,10);
		Disposable subscribe = values
			.filter(v -> v % 2 == 0)
			.subscribe(
			    v -> System.out.println(v),
			    e -> System.out.println("Error: " + e),
			    () -> System.out.println("Completed")
			);

	}

}
