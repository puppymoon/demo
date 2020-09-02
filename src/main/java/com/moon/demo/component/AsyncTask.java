package com.moon.demo.component;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component("AsyncTask")
public class AsyncTask {

	@Async("myTaskExecutor")
	public Future<String> doTaskOne() throws Exception {
		System.out.println("開始做任務一");
		long start = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("完成任務一，耗時：" + (end - start) + "毫秒");
		return new AsyncResult<>("任務一完成");
	}
	
	@Async("myTaskExecutor")
	public Future<String> doTaskTwo() throws Exception {
		System.out.println("開始做任務二");
		long start = System.currentTimeMillis();
		Thread.sleep(5000);
		long end = System.currentTimeMillis();
		System.out.println("完成任務二，耗時：" + (end - start) + "毫秒");
		return new AsyncResult<>("任務二完成");
	}
	
	@Async("myTaskExecutor")
	public Future<String> doTaskThree() throws Exception {
		System.out.println("開始做任務三");
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("完成任務三，耗時：" + (end - start) + "毫秒");
		return new AsyncResult<>("任務三完成");
	}

}
