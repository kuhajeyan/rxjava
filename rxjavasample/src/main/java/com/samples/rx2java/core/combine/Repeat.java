package com.samples.rx2java.core.combine;

import io.reactivex.Observable;

public class Repeat {

	public static void main(String[] args) {
		Observable<Integer> words = Observable.range(0,6);

		words.repeat(2)
			.subscribe(System.out::println);

	}

}
