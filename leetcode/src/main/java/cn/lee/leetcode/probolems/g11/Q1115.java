package cn.lee.leetcode.probolems.g11;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
    * @Title: Q1115
    * @Description: 
    * @author libo
    * @date 2020/8/25 16:56
    * @Version 1.0
    */
@Slf4j
public class Q1115 {
    public static void main(String[] args) throws InterruptedException {
        FooBar foo = new FooBar(10);
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("foo");
                    }
                });
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("bar");
                    }
                });
            }
        });

        t2.start();
        t1.start();
    }
}
class FooBar {
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
//            fooSemaphore.acquire();
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}
