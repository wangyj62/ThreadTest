package com.creditharmony.test;

/**
 * 
 * @Class Name ThreadTest1
 * @author wangyingjie
 * @Create 2017年3月23日
 */
public class ThreadTest1 {

	public static void main(String[] args) {
		ThreadTest1 tt = new ThreadTest1();
		Inc inc = tt.new Inc();
		Dec dec = tt.new Dec();
		for (int i = 0; i < 2; i++) {
			new Thread(inc).start();
			new Thread(dec).start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tt.output();
	}

	private int j = 0;

	public synchronized void output() {
		System.out.println("j的当前值：" + j);
	}

	private synchronized void inc() {
		j++;
		System.out.println(Thread.currentThread().getName() + "-inc:" + j);
	}

	private synchronized void dec() {
		j--;
		System.out.println(Thread.currentThread().getName() + "-dec:" + j);
	}

	class Inc implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				inc();
			}
		}
	}

	class Dec implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				dec();
			}
		}
	}

}
