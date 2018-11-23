package com.samples.rx2java.core.combine;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Merge {

	/**
	 * merge does not wait for the current observable to terminate before moving to
	 * the next. merge subscribes to every observable available to it and emits
	 * items as they come
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		Observable
				.merge(Observable.interval(250, TimeUnit.MILLISECONDS).map(i -> "First"),
						Observable.interval(150, TimeUnit.MILLISECONDS).map(i -> "Second"))
				.take(10).subscribe(System.out::println);
		System.in.read();
	}

}
