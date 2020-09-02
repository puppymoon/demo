package com.moon.demo;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moon.demo.component.AsyncTask;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AsyncTask asyncTask;

	@Test
	void contextLoads() throws Exception {

		long start = System.currentTimeMillis();

		Future<String> task1 = asyncTask.doTaskOne();
		Future<String> task2 = asyncTask.doTaskTwo();
		Future<String> task3 = asyncTask.doTaskThree();

		// 等待5秒後 若沒有結束回傳java.util.concurrent.TimeoutException
		// task2.get(5, TimeUnit.SECONDS);

		// 等待10秒
//		Thread.sleep(10000);
//		if (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
//			// 有任務沒有完成 拋出exception
//			throw new TimeoutException("任務失敗");
//		}

		while (true) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				// 任務全部完成
				break;
			}
		}

		long end = System.currentTimeMillis();

		System.out.println("任務全部完成，總耗時：" + (end - start) + "毫秒");

	}

}
