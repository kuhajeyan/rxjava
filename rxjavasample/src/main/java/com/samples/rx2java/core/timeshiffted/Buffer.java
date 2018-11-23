package com.samples.rx2java.core.timeshiffted;

import io.reactivex.Observable;

public class Buffer {

	public static void main(String[] args) {
		Observable.range(0, 10)
		.buffer(4)
		.subscribe(System.out::println);

	}

}
