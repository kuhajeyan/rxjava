package com.samples.rx2java.core;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservables {

	public static void main(String[] args) throws InterruptedException {
		String[] result = {""};
		ConnectableObservable<Long> connectable
		  = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
		connectable.subscribe(i -> result[0] += i);
		System.out.println(result);
		 
		connectable.connect();
		Thread.sleep(500);
		
		System.out.println("\n");
		  
		System.out.println(result);
	}

}
