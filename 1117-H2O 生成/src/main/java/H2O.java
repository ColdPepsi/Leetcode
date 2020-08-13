/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 类H2O.java的实现描述：CyclicBarrier和Semaphore的应用
 *
 * @author wubiao21 2020年08月07日 14:40:42
 */
public class H2O {

    private final Semaphore hydrogen;
    private final Semaphore oxygen;
    private final CyclicBarrier h2o;


    public H2O() {
        hydrogen = new Semaphore(2);
        oxygen = new Semaphore(1);
        h2o = new CyclicBarrier(3, () -> {//到达屏障之后一起释放
            hydrogen.release(2);
            oxygen.release(1);
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            h2o.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            h2o.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}