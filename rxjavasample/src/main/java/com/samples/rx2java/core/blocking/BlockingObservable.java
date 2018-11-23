package com.samples.rx2java.core.blocking;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class BlockingObservable {

	/**
	 * Blocks until another item comes
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
		
		values
			.take(5)
			.blockingNext()
			.forEach(v -> System.out.println(v));
		System.out.println("Subscribed");

	}

}
