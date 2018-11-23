package com.samples.rx2java.core.errhandling;

import io.reactivex.Observable;

public class OnErrorReturn {

	/**
	 * Returns on error
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<String> values = Observable.create(o -> {
			o.onNext("Rx");
			o.onNext("is");
			o.onNext("is");
			o.onError(new Exception("adjective unknown"));
			o.onNext("java");
			o.onNext("js");
		});

		values.onErrorReturn(e -> "Error: " + e.getMessage()).subscribe(v -> System.out.println(v));

	}

}
