package com.handson.limitsservice.bean;

public class LimitConfiguration {
	private int minimium;
	private int maximum;
	
	
	public LimitConfiguration(int minimium, int maximum) {
		super();
		this.minimium = minimium;
		this.maximum = maximum;
	}
	
	public int getMinimium() {
		return minimium;
	}
	public int getMaximum() {
		return maximum;
	}
	
	

}
