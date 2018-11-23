package com.samples.rx2java.core.blocking;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class BlockingFirst {

	/**
	 * Now we wait until see the first item
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

		long value = values.filter(i -> i > 3).take(5).blockingFirst();

		System.out.println(value);
		System.out.println("i am Done");
	}

}
