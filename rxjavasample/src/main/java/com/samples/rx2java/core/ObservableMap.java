package com.samples.rx2java.core;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableMap {

	/**
	 * Way of applying transformations, on observables
	 * @return
	 */
	public static Observable<String> byObservableMap() {
		Observable<String> map = Observable.<String>just("HighTea", "Capacino").map(t -> t + ":Sweetened")
				.map(t -> t + ":brewed");
		return Observable.concat(map,Observable.just("Lemon"));
	}

	public static void main(String[] args) {
		byObservableMap().subscribe(new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete() {
				System.out.println("Done");
			}
		});

	}

}
