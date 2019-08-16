package com.edu;

import java.util.Date;

import com.edu.designpattern.SingletonDemo;
import com.edu.designpattern.SingletonLazyDemo;

public class Test {

	public static void main(String[] args) {
		testSingleton();
	}

	private static void testSingleton() {
		try {
			System.out.println("--1: " + new Date());
			Thread.sleep(1000);
			SingletonDemo demo = SingletonDemo.getInstance();
			demo.showCreated();
			
			SingletonDemo demo1 = SingletonDemo.getInstance();
			demo1.showCreated();
			
			System.out.println("--2: " + new Date());
			Thread.sleep(1000);
			SingletonLazyDemo demo2 = SingletonLazyDemo.getInstance();
			demo2.showCreated();
			
			SingletonLazyDemo demo3 = SingletonLazyDemo.getInstance();
			demo3.showCreated();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
