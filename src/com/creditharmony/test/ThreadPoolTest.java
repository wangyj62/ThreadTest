package com.creditharmony.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @Class Name ThreadPoolTest
 * @author wangyingjie
 * @Create 2017年3月23日
 */
public class ThreadPoolTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月23日
	 * @param args 
	 */
	public static void main_sss(String[] args) {
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + task);
					}
				}
			});
		}
		// threadPool.shutdown();
		// threadPool.shutdownNow();
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		scheduledThreadPool.scheduleWithFixedDelay(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " bombing!");
			}
		}, 5, 2, TimeUnit.SECONDS);
		
	}

}
