package com.edu;

import java.text.BreakIterator;
import java.util.Date;

import com.edu.designpattern.SingletonDemo;
import com.edu.designpattern.SingletonLazyDemo;

public class Test {

	public static void main(String[] args) {
		testSingleton();
		
		Object obj = new Object() 
	    {
	        public int hashCode() 
	        {
	            return 42;
	        }
	    }; 
	    System.out.println(obj.hashCode()); 
	    
	    String str = null; 
        System.out.println(str); 
//        
//        Math.max(1,4);
//        Math.max(2.3, 5);
//        Math.max(1, 3, 5, 7);
//        Math.max(-1.5, -2.8f);

        double d = Math.round ( 2.5 + Math.random() );
        System.out.println(d);
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
