package com.edu.designpattern;

import java.util.Date;

public class SingletonLazyDemo {
	String createdDate;
//	 for prevent create new by constructor
	private SingletonLazyDemo() {
		this.createdDate = new Date().toString();
	}
	
	/** Create an instance of the class at the time of class loading */
    private static SingletonLazyDemo instance = null;;
	
	public static synchronized SingletonLazyDemo getInstance() {
		if (null == instance) {
			instance = new SingletonLazyDemo();
		}
		return instance;
	}
	
	public void showCreated() {
		System.out.println("------" + createdDate);
	}
}
