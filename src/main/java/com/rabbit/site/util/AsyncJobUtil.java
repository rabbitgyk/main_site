package com.rabbit.site.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步操作工具
 * @author rabbit
 * @date 2015年9月24日 上午9:05:39
 */
public class AsyncJobUtil {
	private static ExecutorService exec = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1);

	public static void doTask(Runnable task) {
		exec.execute(task);
	}
	
	/**
	 * 异步执行任务，
	 * @param tasks
	 * @param timeout 等待时间，毫秒为单位 
	 * @return
	 */
	public static <T> List<T> doFutureTask(Collection<? extends Callable<T>> tasks, long timeout) {
		List<T> result = new ArrayList<T>();
		try {
			List<Future<T>> fts = exec.invokeAll(tasks, timeout, TimeUnit.MILLISECONDS);
			for (Future<T> ft : fts) {
				if(ft.get() != null){
					result.add(ft.get());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
