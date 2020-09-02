package com.moon.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * Threadpool config
 *
 */
@Configuration
public class TaskPoolConfig {

	@Bean("myTaskExecutor")
	public Executor myTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);// 核心執行緒數量，執行緒池建立時候初始化的執行緒數
		executor.setMaxPoolSize(10);// 最大執行緒數，只有在緩衝佇列滿了之後才會申請超過核心執行緒數的執行緒
		executor.setQueueCapacity(20);// 緩衝佇列，用來緩衝執行任務的佇列
		executor.setKeepAliveSeconds(60);// 當超過了核心執行緒出之外的執行緒在空閒時間到達之後會被銷燬
		executor.setThreadNamePrefix("myTask-");// 設定好了之後可以方便我們定位處理任務所在的執行緒池
		executor.setWaitForTasksToCompleteOnShutdown(true);// 用來設定執行緒池關閉的時候等待所有任務都完成再繼續銷燬其他的Bean
		executor.setAwaitTerminationSeconds(10);// 該方法用來設定執行緒池中任務的等待時間，如果超過這個時候還沒有銷燬就強制銷燬，以確保應用最後能夠被關閉，而不是阻塞住。
		// 執行緒池對拒絕任務的處理策略：這裡採用了CallerRunsPolicy策略，當執行緒池沒有處理能力的時候，該策略會直接在 execute
		// 方法的呼叫執行緒中執行被拒絕的任務；如果執行程式已關閉，則會丟棄該任務
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}
}
