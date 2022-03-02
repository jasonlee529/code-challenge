package cn.lee.base;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: ThreadPoolExecutorTest
 * @Description:
 * @author: libo
 * @date: 2022/3/1 17:28
 * @Version: 1.0
 */
@Slf4j
public class ThreadPoolExecutorTest {

	public static void main(String[] args) throws IOException {
		ExecutorService executorService = new ThreadPoolExecutor(2, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		for (int i = 1; i <= 100; i++) {
			int finalI = i;
			executorService.execute(new Runnable() {
				@SneakyThrows
				@Override
				public void run() {
					long mis = Math.round(Math.random() * 10000 / finalI);
					Thread.sleep(mis);
					log.info("{} , {},{}ms", finalI, Thread.currentThread().getName(), mis);
				}
			});
		}
		executorService.shutdown();
	}
}
