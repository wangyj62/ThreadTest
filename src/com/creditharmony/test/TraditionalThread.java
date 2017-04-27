package com.creditharmony.test;

/**
 * 
 * @Class Name TraditionalThread
 * @author wangyingjie
 * @Create 2017年3月17日 
 */
public class TraditionalThread {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月17日
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread: " + Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Runnable: " + Thread.currentThread().getName());
				}				
			}
		}).start();

	}

}
