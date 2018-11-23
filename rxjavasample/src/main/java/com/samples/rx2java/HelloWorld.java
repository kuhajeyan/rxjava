package com.samples.rx2java;

import java.io.IOException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloWorld {

	private static String getData() {
		return "Got Data!";
	}

	public static void main(String[] args) throws IOException {

		// byCreateAndSubscriber();
		// byCreateShorten();
		// byCreateExtended();
		// byCreateVerbose();
		// byCreateThread();
		// byThreadedScheduler();
		// bySchedulerOperator();
		// byOperatorsTake();

		// byWithFallBack();
		// byInteleaved();

		// byTimer();
		
		byObservableFromFuture();

	}

	private static void byObservableFromFuture() {
		FutureTask<Integer> f = new FutureTask<Integer>(() -> {
			Thread.sleep(2000);
			return 21;
		});
		new Thread(f).start();

		Observable<Integer> values = Observable.fromFuture(f);

		Disposable subscribe = values.subscribe(
		    v -> System.out.println("Received: " + v),
		    e -> System.out.println("Error: " + e),
		    () -> System.out.println("Completed")
		);
	}

	private static void byTimer() throws IOException {
		Observable<Long> values = Observable.timer(10, TimeUnit.SECONDS);
		Disposable subscribe = values.subscribe(v -> System.out.println("Received: " + v),
				e -> System.out.println("Error: " + e), () -> System.out.println("Completed"));
		System.in.read();
	}

	private static void byInteleaved() throws IOException {
		Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
		Disposable subscribe = values.subscribe(v -> System.out.println("Received: " + v),
				e -> System.out.println("Error: " + e), () -> System.out.println("Completed"));
		System.in.read();
	}

	private static void byWithFallBack() {
		// Hello World
		Observable.create(subscriber -> {
			throw new RuntimeException("failed!");
		}).onErrorResumeNext(throwable -> {
			return Observable.just("fallback value");
		}).subscribe(System.out::println);
	}

	private static void byOperatorsTake() {
		Observable.create(subscriber -> {
			int i = 0;
			while (!subscriber.isDisposed()) {
				subscriber.onNext(i++);
			}
		}).take(10).subscribe(System.out::println);
	}

	private static void bySchedulerOperator() {
		// add operator
		Observable.create(subscriber -> {
			try {
				subscriber.onNext(getData());
				subscriber.onComplete();
			} catch (Exception e) {
				subscriber.onError(e);
			}
		}).subscribeOn(Schedulers.io()).map(data -> data + " --> at " + System.currentTimeMillis())
				.subscribe(System.out::println);
	}

	private static void byThreadedScheduler() {
		// add concurrency (using a Scheduler)
		Observable.create(subscriber -> {
			try {
				subscriber.onNext(getData());
				subscriber.onComplete();
			} catch (Exception e) {
				subscriber.onError(e);
			}
		}).subscribeOn(Schedulers.io()).subscribe(System.out::println);
	}

	private static void byCreateThread() {
		// add concurrency (manually)
		Observable.create(subscriber -> {
			new Thread(() -> {
				try {
					subscriber.onNext(getData());
					subscriber.onComplete();
				} catch (Exception e) {
					subscriber.onError(e);
				}
			}).start();
		}).subscribe(System.out::println);
	}

	private static void byCreateVerbose() {
		// expand to show full classes
		Observable.create(new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				emitter.onNext("Hello");
				emitter.onComplete();
				// emitter.onError(new RuntimeException());

			}
		}).subscribe(System.out::println, Throwable::printStackTrace, System.out::println);
	}

	private static void byCreateExtended() {
		// add onError and onComplete listeners
		Observable.just("Hello World!").subscribe(System.out::println, Throwable::printStackTrace,
				() -> System.out.println("Done"));
	}

	private static void byCreateShorten() {
		// shorten by using helper method
		Observable.just("Hello", "World!").subscribe(System.out::println);
	}

	private static void byCreateAndSubscriber() {
		// Hello World
		Observable.create(subscriber -> {
			subscriber.onNext("Hello World!");
			subscriber.onComplete();
		}).subscribe(System.out::println);
	}

}
