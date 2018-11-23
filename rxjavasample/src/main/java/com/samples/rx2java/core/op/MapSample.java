package com.samples.rx2java.core.op;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.samples.rx2java.core.PrintSubscriber;

import io.reactivex.Observable;

public class MapSample {

	public static void main(String[] args) throws IOException {
		//bySimpleAdditionUsingMap();
		byMaterialize();

	}

	/**
	 * Print metadata
	 * @throws IOException 
	 */
	private static void byMaterialize() throws IOException {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
		
		values.take(3)
			.materialize()
			.subscribe(new PrintSubscriber("Materialize"));
		System.in.read();
	}

	private static void bySimpleAdditionUsingMap() {
		Observable<Integer> values = Observable.range(0,4);
		
		values
			.map(i -> i + 3)
			.subscribe(new PrintSubscriber("Map"));
	}

}
