package com.hspedu.method;

/**
 * @author: bytedance
 * @date: 2022/1/20
 * @description:
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        //如果我们希望当main线程结束后，子线程可以自动结束
        //只需要将子线程设置成守护线程就可以了
        for (int i = 1; i <= 10; i++) {//main线程
            System.out.println("宝强在辛苦的工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() { //无线循环
        for (; ; ) {
            try {
                Thread.sleep(1000);
                System.out.println("马蓉和宋喆在快乐聊天，哈哈哈~~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}