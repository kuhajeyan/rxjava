package com.samples.rx2java.core.combine;

import io.reactivex.Observable;

public class Concat {

	public static void main(String[] args) {
		Observable<Integer> seq1 = Observable.range(0, 24);
		Observable<Integer> seq2 = Observable.range(10, 3);

		Observable.concat(seq1, seq2)
			.subscribe(System.out::println);

	}

}
