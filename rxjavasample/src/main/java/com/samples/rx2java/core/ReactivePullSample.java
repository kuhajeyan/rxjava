package com.samples.rx2java.core;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ReactivePullSample {

	public static void main(String[] args) {
		Observable<Integer> fromIterable = Observable
				.fromIterable(IntStream.range(1, 100_000).boxed().collect(Collectors.toList()));

		fromIterable.subscribe(new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				
				
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
