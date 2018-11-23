package com.samples.rx2java.core.combine;

import io.reactivex.Observable;

public class ConcatWith {

	public static void main(String[] args) {
		Observable<Integer> seq1 = Observable.range(0, 3);
		Observable<Integer> seq2 = Observable.range(10, 3);
		Observable<Integer> seq3 = Observable.just(20);
		
		seq1.concatWith(seq2)
			.concatWith(seq3)
			.subscribe(System.out::println);

	}

}
