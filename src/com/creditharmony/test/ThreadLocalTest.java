package com.creditharmony.test;

/**
 * 
 * @Class Name ThreadLocalTest
 * @author wangyingjie
 * @Create 2017年3月22日 
 */
public class ThreadLocalTest {
	
	private static ThreadLocal<Integer> localData = new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		//localData.set(1);
		System.out.println("localData.get() -- > " + localData.get());
		ThreadScopeData.getThreadInstance();
	}

}

class ThreadScopeData{
	
	private static ThreadLocal<ThreadScopeData> map = new ThreadLocal<ThreadScopeData>();
	
	private ThreadScopeData(){};
	
	public static ThreadScopeData getThreadInstance(){
		ThreadScopeData scopeData = map.get();
		if(scopeData == null){
			scopeData = new ThreadScopeData();
			map.set(scopeData);
		}
		return scopeData;
	}
	
	private String name;
	
	private int age;

	/**  
	 * 获取name  
	 * @return name name  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * 设置name  
	 * @param name name  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  
	 * 获取age  
	 * @return age age  
	 */
	public int getAge() {
		return age;
	}

	/**  
	 * 设置age  
	 * @param age age  
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}
