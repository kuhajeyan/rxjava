package com.samples.rx2java.core.sideeffect;

import io.reactivex.Observable;

public class SideEffectScary {

	/**
	 * Beware of creating side effects
	 * @param args
	 */
	public static void main(String[] args) {
		Observable<Data> data = Observable.just(
				new Data(1, "Microsoft"),
				new Data(2, "Netflix")
			);

			data.subscribe(d -> d.name = "Garbage");
			data.subscribe(d -> System.out.println(d.id + ": " + d.name));

	}
	
	public static class Data {
		public int id;
		public String name;
		public Data(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}

}
