package com.zhang;

import com.zhang.test.MyThread;

public class Test {

	public static void main(String[] args) {
		new MyThread().start();
		for(int i = 0; i < 100000; i++) {
			if (i > 0 && (i % 1000) == 0) {
				System.out.println(i);
			}
		}
		
		
	}


}
