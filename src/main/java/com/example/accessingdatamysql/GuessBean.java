package com.example.accessingdatamysql;

public class GuessBean {
	
	String guess;
	
	public GuessBean(String guess) {
		super();
		this.guess = guess;
	}
	
	public GuessBean() {
		super();
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	
}
