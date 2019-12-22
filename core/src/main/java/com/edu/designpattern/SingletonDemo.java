package com.edu.designpattern;

import java.util.Date;

public class SingletonDemo {
	String createdDate;
//	 for prevent create new by constructor
	private SingletonDemo() {
		this.createdDate = new Date().toString();
	}
	
	/** Create an instance of the class at the time of class loading */
    private static final SingletonDemo instance = new SingletonDemo();
	
	public static SingletonDemo getInstance() {
		return instance;
	}
	
	public void showCreated() {
		System.out.println("------" + createdDate);
	}
}
