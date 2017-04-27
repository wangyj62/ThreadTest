package com.creditharmony.test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @Class Name CallableAndFuture
 * @author wangyingjie
 * @Create 2017年3月24日 
 */
public class CallableAndFuture {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月24日
	 * @param args
	 */
	public static void main_temp_1() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future future = threadPool.submit(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("asdf....");
			}
		});
		System.out.println("。。。。。。");
		try {
			System.out.println(future.get());;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月24日
	 * @param args
	 */
	public static void main_temp_2() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Boolean> future = threadPool.submit(new Callable<Boolean>(){
			@Override
			public Boolean call() throws Exception {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
			}
		});
		System.out.println("已提交，等待结果。。。。。。");
		try {
			System.out.println("拿到结果： " + future.get());;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main_temp_3() {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "this is result";
			}
		});
		System.out.println("已提交，另外处理其他任务");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("去获得结果： " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main_temp_4() {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);
		for(int i=0;i<10;i++){
			final int seq = i;
			completionService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(new Random().nextInt(10000));
					return "this task is ok seq for : " + seq;
				}
			});
		}
		System.out.println("all task already submit"); 
		for(int i=0;i<10;i++){
			try {
				System.out.println("result : " + completionService.take().get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// main_temp_1();
		// main_temp_2();
		// main_temp_3();
		main_temp_4();
	}

}
