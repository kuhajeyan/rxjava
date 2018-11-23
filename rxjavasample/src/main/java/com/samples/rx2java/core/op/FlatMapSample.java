package com.samples.rx2java.core.op;

import com.samples.rx2java.core.PrintSubscriber;

import io.reactivex.Observable;

public class FlatMapSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> values = Observable.just(2,2,2,2,3,4,5,7,3,1);

		values
			.flatMap(i -> Observable.range(0,i))
			.subscribe(new PrintSubscriber("flatMap"));
	}

}
