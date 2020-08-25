package cn.lee.leetcode;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author libo
 * @Title: Q1114
 * @Description:
 * @date 2020/8/25 14:44
 * @Version 1.0
 */
@Slf4j
public class Q1114 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo2();
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.first(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("f1");
                    }
                });
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.second(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("f2");
                    }
                });
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                foo.third(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("f3");
                    }
                });
            }
        });
        t2.start();
        t3.start();
        t1.start();
    }
}

class Foo {
    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);
    public Foo() {

    }
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        two.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        printSecond.run();
        three.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        printThird.run();
    }
}
class Foo2 extends Foo {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo2() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }

}