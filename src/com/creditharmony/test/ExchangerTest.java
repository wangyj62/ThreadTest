package com.creditharmony.test;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "111111111";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}
			}	
		});
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "2222222222";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});	
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "3333333333";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});	
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "4444444444";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});	
		
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "55555555555555";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});	
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "66666";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"正在把数据" + data1 +"换出去");
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据为" + data2);
				}catch(Exception e){
					
				}				
			}	
		});	
	}
}
