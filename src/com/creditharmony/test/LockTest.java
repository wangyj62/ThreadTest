package com.creditharmony.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Class Name LockTest
 * @author wangyingjie
 * @Create 2017年3月31日
 */
public class LockTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月31日
	 * @param args
	 */
	public static void main(String[] args) {
		final Output output = new Output();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					output.output("11111111111");
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					output.output("22222222222");
				}
			}
		}).start();
	}

}

class Output {
	private Lock outputLock = new ReentrantLock();
//	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public void output(String name) {
		outputLock.lock();
		try {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		} finally {
			outputLock.unlock();
		}
	}

}
