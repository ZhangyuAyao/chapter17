package com.hspedu.syn;

/**
 * @author: bytedance
 * @date: 2022/1/20
 * @description:
 */
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (o1) {//对象互斥锁
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {//哲理获得li对象的监视权
                    System.out.println(Thread.currentThread().getName()+"进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"进入4");
                }
            }
        }
    }
}
