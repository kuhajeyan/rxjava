package com.samples.rx2java.core.observables;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class HotObservables {

	/**
	 *  Cold observables become hot with the publish()
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		ConnectableObservable<Long> cold = Observable.interval(100, TimeUnit.MILLISECONDS).publish();
		cold.connect();

		cold.take(10).subscribe(i -> System.out.println("First: " + i));
		Thread.sleep(500);
		cold.take(10).subscribe(i -> System.out.println("Second: " + i));
		System.in.read();
	}

}
