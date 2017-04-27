package com.creditharmony.test;

/**
 * 
 * @Class Name TraditionalThreadSynchronized
 * @author wangyingjie
 * @Create 2017年3月18日
 */
public class TraditionalThreadSynchronized {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月18日
	 * @param args
	 */
	public static void main(String[] args) {
		TraditionalThreadSynchronized traditionalThreadSynchronized = new TraditionalThreadSynchronized();
		traditionalThreadSynchronized.init();
	}
	
	public void init(){
		final Outputer out = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					out.output("zhangxiaoxiang");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					out.output("lihuoming");
				}
			}
		}).start();
	}

	class Outputer {
		public void output(String name) {
			int len = name.length();
			synchronized(name)
			{
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}

}
