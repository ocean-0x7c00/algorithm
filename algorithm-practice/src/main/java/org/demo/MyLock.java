package org.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class MyLock implements Lock {
    //表示谁获得了当前锁，抢锁抢的就是owner
    AtomicReference<Thread> owner = new AtomicReference<>();


    //等待队列
    private LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null, Thread.currentThread());

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if (owner.compareAndSet(Thread.currentThread(), null)) {
            Thread head = waiters.peek();
            if (head != null) {
                LockSupport.unpark(head);
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
