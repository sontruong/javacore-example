package com.edu.text;

import java.text.BreakIterator;
import java.util.Locale;

import com.edu.utils.FileUtils;

public class TextBreakIterator {
	
	public static void main(String[] strs) {
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		String str = FileUtils.readLineByLineJava8("D:\\AppData\\bigdata\\java-breakiterator.txt");
		iterator.setText(str);
		int start = iterator.first();
		for (int end = iterator.next();
		    end != BreakIterator.DONE;
		    start = end, end = iterator.next()) {
			System.out.println(str.substring(start,end));
		}
	}
	
	
}
