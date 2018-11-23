package com.samples.rx2java.core.blocking;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MonadExp {

	/**
	 * since it is non blocking application has exited before being run by the operators
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

		values
			.take(5)
			.forEach(v -> System.out.println(v));
		System.out.println("Subscribed");

	}

}
