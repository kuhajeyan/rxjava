package com.samples.rx2java.core.combine;

import io.reactivex.Observable;

public class GroupBy {

	public static void main(String[] args) {
		Observable<String> words = Observable.just("First", "Second", "Third", "Fourth", "Fifth", "Sixth");

		Observable.concat(words.groupBy(v -> v.charAt(0))).subscribe(System.out::println);

	}

}
