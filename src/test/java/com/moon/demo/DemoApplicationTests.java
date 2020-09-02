package com.moon.demo;

import java.util.concurrent.Future;

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

		while (true) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三個任務都呼叫完成，退出迴圈等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任務全部完成，總耗時：" + (end - start) + "毫秒");

	}

}
