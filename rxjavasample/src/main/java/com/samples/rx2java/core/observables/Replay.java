package com.samples.rx2java.core.observables;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

public class Replay {

	public static void main(String[] args) throws InterruptedException {
		ConnectableObservable<Long> cold = Observable.interval(200, TimeUnit.MILLISECONDS).replay();
		Disposable connect = cold.connect();

		System.out.println("Subscribe first");
		Disposable s1 = cold.subscribe(i -> System.out.println("First: " + i));
		Thread.sleep(700);
		System.out.println("Subscribe second");
		Disposable s2 = cold.subscribe(i -> System.out.println("Second: " + i));
		Thread.sleep(500);

	}

}
