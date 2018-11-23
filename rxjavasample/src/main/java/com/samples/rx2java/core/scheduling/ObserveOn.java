package com.samples.rx2java.core.scheduling;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObserveOn {

	/**
	 * The creation and emission of values will work like normal, but the actions of
	 * your observer will be invoked on a different thread, as specified by the
	 * Scheduler policy.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Main: " + Thread.currentThread().getId());
		Observable.create(o -> {
			System.out.println("Created on " + Thread.currentThread().getId());
			o.onNext(1);
			o.onNext(2);
			o.onComplete();
		}).observeOn(Schedulers.newThread())
				.subscribe(i -> System.out.println("Received " + i + " on " + Thread.currentThread().getId()));
		System.in.read();
	}

}
