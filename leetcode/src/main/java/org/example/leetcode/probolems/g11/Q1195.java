package org.example.leetcode.probolems.g11;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author libo
 * @Title: Q1195
 * @Description:
 * @date 2020/8/26 17:42
 * @Version 1.0
 */
@Slf4j
public class Q1195 {
    public static void main(String[] args) {
        FizzBuzz foo = new FizzBuzz(30);
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("fizz");
                    }
                });
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("buzz");
                    }
                });
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("fizzbuzz");
                    }
                });
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.number(System.out::print);
            }
        });
        t2.start();
        t1.start();
        t3.start();
        t4.start();
    }

}

class FizzBuzz {
    private int n;
    CyclicBarrier barrier = new CyclicBarrier(4);
    private AtomicInteger ai = new AtomicInteger(1);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (ai.get()==i && i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                ai.incrementAndGet();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (ai.get()==i &&i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                ai.incrementAndGet();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (ai.get()==i &&i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                ai.incrementAndGet();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (ai.get()==i &&i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                ai.incrementAndGet();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}