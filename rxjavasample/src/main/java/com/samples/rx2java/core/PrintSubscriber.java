package com.samples.rx2java.core;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PrintSubscriber implements Observer{
	private final String name;
	public PrintSubscriber(String name) {
		this.name = name;
	}
	@Override
	public void onComplete() {
		System.out.println(name + ": Completed");
	}
	@Override
	public void onError(Throwable e) {
		System.out.println(name + ": Error: " + e);
	}
	@Override
	public void onNext(Object v) {
		System.out.println(name + ": " + v);
	}
	@Override
	public void onSubscribe(Disposable d) {
		System.out.println("Subscribed");
		
	}
}
