package com.creditharmony.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * @Class Name SemaphoreTest
 * @author wangyingjie
 * @Create 2017年4月20日
 */
public class SemaphoreTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年4月20日
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3, true);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + 
							"进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
					try {
						Thread.sleep(new Random().nextInt(20000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
					sp.release();
					System.out.println("线程" + Thread.currentThread().getName() + 
							"已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
				}
			};
			threadPool.execute(runnable);
		}

	}

}
