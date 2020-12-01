package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="results")
public class Result {
	
	@Id
	@GeneratedValue
	private int id;
	private int result;
	
	public Result(int id, int result) {
		super();
		this.id = id;
		this.result = result;
	}
	
	public Result(int result) {
		this.result = result;
	}
	
	public Result() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
