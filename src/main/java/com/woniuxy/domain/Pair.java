package com.woniuxy.domain;

public class Pair<A,B> {
	
	public final A first;
	public final B second;

	
	public Pair(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}


	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
	 
	
}
