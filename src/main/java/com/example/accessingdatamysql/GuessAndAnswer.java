package com.example.accessingdatamysql;

public class GuessAndAnswer {

	String guess;
	String answer;
	
	public GuessAndAnswer() {
		super();
	}
	public GuessAndAnswer(String guess, String answer) {
		super();
		this.guess = guess;
		this.answer = answer;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
