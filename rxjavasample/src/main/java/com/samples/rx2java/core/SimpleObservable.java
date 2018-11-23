package com.samples.rx2java.core;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleObservable {

	public static Observable<String> byExplicitCreate() {
		return Observable.create(new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				emitter.onNext("Bye bye!");
				emitter.onComplete();
				
			}
		});
	}
	
	

	public static void hello(String... names) {

		Observable.fromArray(names).subscribe(new Observer<String>() {

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
				System.out.println("Completed");

			}
		});
	}

	public static void main(String args[]) {
		
		Observable<Integer> just = Observable.just(Integer.valueOf(2));
		
		Observer<Integer> observer1 = new Observer<Integer>() {
			
			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onNext(Integer t) {
				System.out.println(t);
			}
			
			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onComplete() {
				System.out.println("Counted");
			}
		};
		
		just.subscribe(observer1);
		
		hello(new String[] { "Pasta", "Macroni", "Pizza" });

		Observable<String> byExplicitCreate = byExplicitCreate();
		byExplicitCreate.subscribe(s -> System.out.println(s), e -> e.printStackTrace(),
				() -> System.out.println("Done1"));
		byExplicitCreate.subscribe(s -> System.out.println(s), e -> e.printStackTrace(),
				() -> System.out.println("Done2"));
	}

}
