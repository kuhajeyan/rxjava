package com.samples.rx2java.core.timeshiffted;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Throttle {

	/**
	 * After a value has been accepted, values will be rejected for the duration of
	 * the window
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Observable.interval(150, TimeUnit.MILLISECONDS).throttleFirst(1, TimeUnit.SECONDS)
				.subscribe(System.out::println);

	}

}
