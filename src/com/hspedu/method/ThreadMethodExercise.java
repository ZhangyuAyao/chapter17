package com.hspedu.method;

/**
 * @author: bytedance
 * @date: 2022/1/20
 * @description:
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
            if(i == 5) {
                Thread01 thread01 = new Thread01();
                Thread thread = new Thread(thread01);
                thread.start();
                thread.join();
            }
        }
    }
}

class Thread01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello" + i);
        }
    }
}
