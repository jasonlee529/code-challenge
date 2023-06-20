package cn.lee.leetcode.probolems.g11;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author libo
 * @Title: Q1117
 * @Description:
 * @date 2020/8/26 16:41
 * @Version 1.0
 */
@Slf4j
public class Q1117 {
    public static void main(String[] args) throws InterruptedException {
        H2O foo = new H2O();
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 8; i++) {
                    System.out.println("t1-H"+i);
                    int finalI = i;
                    foo.hydrogen(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("H"+ finalI);
                        }
                    });
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println("t2-O"+i);
                    int finalI = i;
                    foo.oxygen(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("O"+ finalI);
                        }
                    });
                }
            }
        });
        t2.start();
        t1.start();
    }
}

class H2O {

    private Semaphore hSema = new Semaphore(2);
    private Semaphore oSema = new Semaphore(1);
    private CyclicBarrier cb = new CyclicBarrier(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
        hSema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSema.acquire();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseOxygen.run();
        oSema.release();
    }
}

