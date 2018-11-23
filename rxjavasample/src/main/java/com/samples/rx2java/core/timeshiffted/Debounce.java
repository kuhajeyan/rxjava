package com.samples.rx2java.core.timeshiffted;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Debounce {

	/**
	 * In this operator, a time window starts every time a value is received. Once
	 * the window expires, the value is emitted. If, however, another value is
	 * received before the window expires, the previous value is rejected and the
	 * window restarts for the next value.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Observable
				.concat(Observable.interval(100, TimeUnit.MILLISECONDS).take(3),
						Observable.interval(500, TimeUnit.MILLISECONDS).take(3),
						Observable.interval(100, TimeUnit.MILLISECONDS).take(3))
				.scan(0, (acc, v) -> acc + 1).debounce(150, TimeUnit.MILLISECONDS).subscribe(System.out::println);
		System.in.read();
	}

}
