package com.creditharmony.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Class Name ReadWriteLockTest
 * @author wangyingjie
 * @Create 2017年4月17日 
 */
public class ReadWriteLockTest {

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年4月17日
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	

}

class CacheDemo{
	
	private Map<String, Object> cache = new HashMap<String, Object>();
	
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public Object getData(String key){
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				if(value == null){
					value = "DB result";// query DB 
					cache.put(key, value);
				}
				rwl.readLock().lock();
				rwl.writeLock().unlock();
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
	
}
