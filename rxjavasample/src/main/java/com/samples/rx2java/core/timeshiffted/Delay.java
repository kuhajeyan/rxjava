package com.samples.rx2java.core.timeshiffted;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Delay {

	public static void main(String[] args) throws IOException {
		Observable.interval(100, TimeUnit.MILLISECONDS).take(5)
		.delay(1, TimeUnit.SECONDS)
		.timeInterval()
		.subscribe(System.out::println);
		System.in.read();
	}

}
