package com.example.accessingdatamysql;

public class PlayerAverage {
	
	String name;
	double average;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAverage() {
		return average;
	}
	
	public void setAverage(double average) {
		this.average = average;
	}
	public PlayerAverage(String name, double average) {
		super();
		this.name = name;
		this.average = average;
	}

}
