package com.samples.rx2java.core.scheduling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MainSingle {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Main: " + Thread.currentThread().getId());
		
		//run on own thread
		Observable.interval(500, TimeUnit.MILLISECONDS)
			.subscribe(i -> {
				System.out.println("Received " + i + " on " + Thread.currentThread().getId());
			});

		System.out.println("Finished main: " + Thread.currentThread().getId());
		System.in.read();
	}

}
