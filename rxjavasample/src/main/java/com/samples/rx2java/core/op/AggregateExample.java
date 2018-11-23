package com.samples.rx2java.core.op;

import io.reactivex.Observable;

public class AggregateExample {

	public static void main(String[] args) {
		//byReduceSum();
		
		byScan();

	}

	/**
	 * Similar to reduce, emit intermediate results
	 */
	private static void byScan() {
		Observable<Integer> values = Observable.range(0,5);
		
		values
			.scan((i1,i2) -> i1+i2)
			.subscribe(System.out::println);
	}

	private static void byReduceSum() {
		Observable<Integer> values = Observable.range(0,6);
		
		values
			.reduce((i1,i2) -> i1+i2)
			.subscribe(System.out::println);
		values
			.reduce((i1,i2) -> (i1>i2) ? i2 : i1)
			.subscribe(System.out::println);
	}

}
