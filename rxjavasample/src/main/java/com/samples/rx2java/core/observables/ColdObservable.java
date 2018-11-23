package com.samples.rx2java.core.observables;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ColdObservable {

	/**
	 * No emission until a subscription
	 * 
	 * 
	 * Cold observables are observables that run their sequence when and if they are
	 * subscribed to. They present the sequence from the start to each subscriber.
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Observable<Long> cold = Observable.interval(200, TimeUnit.MILLISECONDS);

		cold.take(7).subscribe(i -> System.out.println("First: " + i));
		Thread.sleep(500);
		cold.take(7).subscribe(i -> System.out.println("Second: " + i));
		System.in.read();
	}

}
