/**
 * 
 */
package com.edu.heap_stack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author vinhson
 *
 */
public class Memoryleak {
	public static final ArrayList<Double> list = new ArrayList<Double>(1000000);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		declareManyObj();
//		manyStatic();
//		add string
		long i = 0;
		String t = "";
		while (i < 1000000) {
			t += "TestJavaMemoryTestJavaMemoryTestJavaMemoryTestJavaMemoryTestJavaMemoryTestJavaMemoryTestJavaMemoryTestJavaMemory";
		}
	}

	/**
	 * not leak
	 */
	private static void manyStatic() {
		//		many static item
		Long l = 0l;
		Random random = new Random();
		for (int i = 0; i < 11000000; i++) {
	        list.add(random.nextDouble());
	        l++;
	        System.out.println("---: " + l);
	    }
	}

//	not leak at ---: 20436881 time
	private static void declareManyObj() {
		Long l = 0l;
		while (true) {
			l++;
			BigDecimal bigDecimal = new BigDecimal(22432423D);
			System.out.println("---: " + l + " - " + bigDecimal);
		}
	}

}
