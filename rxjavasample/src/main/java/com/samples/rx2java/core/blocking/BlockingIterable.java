package com.samples.rx2java.core.blocking;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class BlockingIterable {

	/**
	 * Block until we take 5 items , and values are cached until subscriber calls on block
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);
		
		Iterable<Long> iterable = values.take(100).blockingIterable();
		for (long l : iterable) {
			System.out.println(l);
		}
		
		
		System.out.println("I am done");
	}

}
