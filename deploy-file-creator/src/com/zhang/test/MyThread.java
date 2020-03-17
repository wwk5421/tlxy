package com.zhang.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zhang.utils.DateUtils;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "\t------start-----" + DateUtils.dateToString(new Date(System.currentTimeMillis())));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "\t------end-----" + DateUtils.dateToString(new Date(System.currentTimeMillis())));

		// System.out.println(1/0);
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);


		for (int i = 0; i < 100; i++) {
			pool.execute(new MyThread());
		}
		
		System.out.println("sb");

	}

}
