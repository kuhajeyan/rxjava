package com.samples.rx2java.core.op;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class UtilityOps {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// bySimpleTake();

		// bySimpleSkip();
		// byAll();

		//byAny();
		
		//byContains();
		
		//byCount();
	}

	private static void byCount() {
		Observable<Integer> values = Observable.range(0, 3);
		//System.out.println(values.count().blockingGet());
		values.count().subscribe(System.out::println);
	}

	private static void byContains() throws IOException {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);
		
		Disposable subscribe = values
			.contains(4L)
			.subscribe(
			    v -> System.out.println(v)
			   
			);
		System.in.read();
	}

	private static void byAny() {
		Observable<Integer> values = Observable.range(0, 3);

		values.any(i -> i > 2).subscribe(v -> System.out.println(v)

		);
	}

	private static void byAll() {
		Observable<Integer> values = Observable.create(o -> {
			o.onNext(0);
			o.onNext(10);
			o.onNext(10);
			o.onNext(2);
			o.onComplete();
		});

		values.all(i -> i % 2 == 0).subscribe(t -> System.out.println(t));
	}

	private static void bySimpleSkip() {
		Observable<Integer> values = Observable.range(0, 5);

		Disposable subscribe = values.skip(2).subscribe(v -> System.out.println(v),
				e -> System.out.println("Error: " + e), () -> System.out.println("Completed"));
	}

	private static void bySimpleTake() {
		Observable<Integer> values = Observable.range(0, 5);

		Disposable subscribe = values.take(2).subscribe(v -> System.out.println(v),
				e -> System.out.println("Error: " + e), () -> System.out.println("Completed"));
	}

}
