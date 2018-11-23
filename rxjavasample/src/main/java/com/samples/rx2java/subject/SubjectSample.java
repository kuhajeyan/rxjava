package com.samples.rx2java.subject;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class SubjectSample {

	public static void main(String[] args) {
		// byPublishSubject();

		// byReplaySubject();

		// byReplaySubjectWithBuffer();

		// byBehaviourSubject();

		// byImplicitSubject();

	}

	/**
	 * it counts its max buff size
	 */
	private static void byReplaySubjectWithBuffer() {
		ReplaySubject<Integer> s = ReplaySubject.createWithSize(2);
		s.onNext(0);
		s.onNext(1);
		s.onNext(2);
		s.subscribe(v -> System.out.println("Late: " + v));
		s.onNext(3);
	}

	/**
	 * Explicit call to complete, disconnects the observer
	 */
	private static void byImplicitSubject() {
		Subject<Integer> s = ReplaySubject.create();
		s.subscribe(v -> System.out.println(v));
		s.onNext(0);
		s.onComplete();
		s.onNext(1);
		s.onNext(2);
	}

	private static void byBehaviourSubject() {
		BehaviorSubject<Integer> s = BehaviorSubject.create();
		s.onNext(0);
		s.onNext(1);
		s.onNext(2);
		s.subscribe(v -> System.out.println("Late: " + v));
		s.onNext(3);
	}

	/**
	 * Cares about buffering
	 */
	private static void byReplaySubject() {
		byReplaySubjectWithBuffer();
	}

	/**
	 * Does not care about the subscribtion time line
	 */
	private static void byPublishSubject() {
		PublishSubject<Integer> subject = PublishSubject.create();
		subject.onNext(1);
		subject.subscribe(System.out::println);
		subject.onNext(2);
		subject.onNext(3);
		subject.onNext(4);
	}

}
