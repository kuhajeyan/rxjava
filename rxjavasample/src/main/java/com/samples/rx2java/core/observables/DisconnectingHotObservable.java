package com.samples.rx2java.core.observables;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

public class DisconnectingHotObservable {

	public static void main(String[] args) throws InterruptedException, IOException {
		ConnectableObservable<Long> connectable = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
		Disposable s = connectable.connect();

		Disposable subscribe = connectable.subscribe(i -> System.out.println(i));

		Thread.sleep(1000);
		System.out.println("Closing connection");
		subscribe.dispose();

		Thread.sleep(1000);
		System.out.println("Reconnecting");
		s = connectable.connect();
		
		System.in.read();

	}

}
