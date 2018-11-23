package com.samples.rx2java.core.scheduling;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObserveOnSpecial {

	public static void main(String[] args) throws IOException {
		Observable.create(o -> {
			System.out.println("Created on " + Thread.currentThread().getId());
			o.onNext(1);
			o.onNext(2);
			o.onComplete();
			
		})
		.doOnNext(i -> 
			System.out.println("Before " + i + " on " + Thread.currentThread().getId()))
		.observeOn(Schedulers.newThread())
		.doOnNext(i -> 
			System.out.println("After " + i + " on " + Thread.currentThread().getId()))
		.subscribe();
		System.in.read();
	}

}
