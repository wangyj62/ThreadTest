package com.creditharmony.test;

/**
 * 
 * @Class Name VolatileTest
 * @author wangyingjie
 * @Create 2017年4月13日 
 */
public class VolatileTest {
	// sdfdsalkfjdslfkds
	// fsdlkjfsdlkjfds;lf
	// lkfdslkdsjfdslkjfs

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年4月13日
	 * @param args
	 */
	public static void main(String[] args) {
		final VolatileTest volatileTest = new VolatileTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					volatileTest.printNumValue();
					/*if(volatileTest.num){
						
					}*/
				}
			}
		}).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//volatileTest.increase();
		volatileTest.printNumValue();
	}
	
	public  int num = 2;
	
	public void printNumValue(){
		System.out.println(Thread.currentThread().getName() + " : " + num);
	}
	
	public void increase(){
		num++;
	}

}
