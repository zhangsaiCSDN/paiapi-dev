package com.woniuxy.domain;

public class Triplet<A,B,C> {
	
	public final A first;
	public final B second;
	public final C three;
	
	public Triplet(A first, B second, C three) {
		super();
		this.first = first;
		this.second = second;
		this.three = three;
	}
	
	
	public A getFirst() {
		return first;
	}


	public B getSecond() {
		return second;
	}


	public C getThree() {
		return three;
	}


	@Override
	public String toString() {
		return "Triplet [first=" + first + ", second=" + second + ", three=" + three + "]";
	}
	 
	
}
