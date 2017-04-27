package com.creditharmony.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Class Name ConditionTest
 * @author wangyingjie
 * @Create 2017年4月14日
 */
public class ConditionTest {
	public static void main(String[] args) {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					outputer.subThred();
				}
			}
		}).start();
		
		for (int i = 0; i < 50; i++) {
			outputer.mainThred();
		}
		
	}
}

class Outputer {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void mainThred() {
		lock.lock();
		try {
			System.out.println("主线程开始唤醒对方。。");
			condition.signal();
			System.out.println("主线程已唤醒对方。。");
			for (int i = 1; i <= 2; i++) {
				System.out.println("主线程执行次数--> " + i);
			}
			try {
				System.out.println("主线程开始等待。。");
				condition.await();
				System.out.println("主线程等待完毕。。");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}
	}

	public void subThred() {
		lock.lock();
		try {
			System.out.println("子线程开始唤醒对方。。");
			condition.signal();
			System.out.println("子线程已唤醒对方。。");
			for (int i = 1; i <= 3; i++) {
				System.out.println("子线程执行次数--> " + i);
			}
			try {
				System.out.println("子线程开始等待。。");
				condition.await();
				System.out.println("子线程等待完毕。。");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}
	}

}