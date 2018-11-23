package com.samples.rx2java.core.blocking;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class BlockingNext {

	/**
	 * Values are not cached, as soon the first item appears , Typically our consumer is slow
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);
		
		values.take(5)
			.subscribe(v -> System.out.println("Emitted: " + v));

		Iterable<Long> iterable = values.take(5).blockingNext();
		for (long l : iterable) {
			System.out.println(l);
			Thread.sleep(750);
		}
		
		System.out.println("I am done");

	}

}
