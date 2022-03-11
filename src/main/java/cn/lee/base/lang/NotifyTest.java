package cn.lee.base.lang;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: a
 * @Description:
 * @author: libo
 * @date: 2022/3/9 11:09
 * @Version: 1.0
 */
@Slf4j
public class NotifyTest {
	public synchronized void testWait() {
		System.out.println(Thread.currentThread().getName() + " Start-----");
		try {
			wait(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End-------");
	}

	public static void main(String[] args) throws InterruptedException {
		final NotifyTest test = new NotifyTest();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					test.testWait();
				}
			}).start();
		}

		synchronized (test) {
			test.notify();
		}
		Thread.sleep(3000);
		System.out.println("-----------分割线-------------");

		synchronized (test) {
			test.notifyAll();
		}
	}
}
