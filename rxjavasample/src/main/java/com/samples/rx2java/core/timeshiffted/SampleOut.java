package com.samples.rx2java.core.timeshiffted;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class SampleOut {

	public static void main(String[] args) throws IOException {
		Observable.interval(150, TimeUnit.MILLISECONDS)
		.sample(1, TimeUnit.SECONDS).take(10)
		.subscribe(System.out::println);
		System.in.read();
	}

}
