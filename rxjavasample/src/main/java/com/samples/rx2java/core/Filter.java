package com.samples.rx2java.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Filter {
	
	private static Observable<Integer> byFilter(Integer[] numbers) {
		Observable<Integer> map = Observable.fromArray(numbers).filter(t -> t%2 == 0).map(t -> t+2);
		return map;
	}

	public static void main(String[] args) {
		List<Integer> boxed = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		
		byFilter(boxed.toArray(new Integer[boxed.size()])).subscribe(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) throws Exception {
				System.err.println(t);
			}
		});
	}

}
