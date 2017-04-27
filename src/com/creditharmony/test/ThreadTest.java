package com.creditharmony.test;

/**
 * 
 * @Class Name ThreadTest
 * @author wangyingjie
 * @Create 2017年3月18日
 */
public class ThreadTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月18日
	 * @param args
	 */
	public static void main(String[] args) {
		final Outputer_a outputer = new Outputer_a();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					outputer.subThred();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					outputer.mainThred();
				}
			}
		}).start();
	}

}

class Outputer_a {

	public synchronized void mainThred() {
		System.out.println("主线程开始唤醒对方。。");
		this.notify();
		System.out.println("主线程已唤醒对方。。");
		for (int i = 1; i <= 2; i++) {
			System.out.println("主线程执行次数--> " + i);
		}
		try {
			System.out.println("主线程开始等待。。");
			this.wait();
			System.out.println("主线程等待完毕。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void subThred() {
		System.out.println("子线程开始唤醒对方。。");
		this.notify();
		System.out.println("子线程已唤醒对方。。");
		for (int i = 1; i <= 3; i++) {
			System.out.println("子线程执行次数--> " + i);
		}
		try {
			System.out.println("子线程开始等待。。");
			this.wait();
			System.out.println("子线程等待完毕。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
