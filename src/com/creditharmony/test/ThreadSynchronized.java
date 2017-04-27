package com.creditharmony.test;

/**
 * 
 * @Class Name ThreadSynchronized
 * @author wangyingjie
 * @Create 2017年3月18日 
 */
public class ThreadSynchronized {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月18日
	 * @param args
	 */
	public static void main(String[] args) {
		Bussess bussess = new Bussess();
		bussess.deal();
	}

}

class Bussess{
	
	public void deal(){
		synchronized(""){
			try {
				System.out.println("-----------------> ");
				"s".wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
