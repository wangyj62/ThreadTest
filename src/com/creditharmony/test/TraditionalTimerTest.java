package com.creditharmony.test;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @Class Name TraditionalTimerTest
 * @author wangyingjie
 * @Create 2017年3月17日 
 */
public class TraditionalTimerTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年3月17日
	 * @param args
	 */
	public static void main(String[] args) {
		new Timer().schedule(productionBomb_5(),0);
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Calendar.getInstance().get(Calendar.SECOND));
		}
	}
	
	public static TimerTask productionBomb_3(){
		return new TimerTask(){
			@Override
			public void run() {
				System.out.println("bombing!");
				new Timer().schedule(productionBomb_5(), 3000);
			}
		};
	}
	
	public static TimerTask productionBomb_5(){
		return new TimerTask(){
			@Override
			public void run() {
				System.out.println("bombing!");
				new Timer().schedule(productionBomb_3(), 5000);
			}
		};
	}
	
	private static int count = 0;
	class MyTimerTask extends TimerTask{
		@Override
		public void run() {
			count++;
			System.out.println("bombing!");
			new Timer().schedule(new MyTimerTask(), count%2 ==0 ? 3000 : 5000);
		}
		
	}

}
