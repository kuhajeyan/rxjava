package com.samples.rx2java.core.scheduling;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SubscribeOn {

	public static void main(String[] args) throws IOException {
		System.out.println("Main: " + Thread.currentThread().getId());
		
		Observable.create(o -> {
				System.out.println("Created on " + Thread.currentThread().getId());
				o.onNext(1);
				o.onNext(2);
				o.onComplete();
			})
			.subscribeOn(Schedulers.newThread())
			.subscribe(i -> {
				System.out.println("Received " + i + " on " + Thread.currentThread().getId());
			});

		System.out.println("Finished main: " + Thread.currentThread().getId());
		System.in.read();
	}

}
