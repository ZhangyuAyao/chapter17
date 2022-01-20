package com.hspedu.syn;

/**
 * @author: bytedance
 * @date: 2022/1/19
 * @description: 使用多线程，模拟三个窗口同时售票100张票
 */
public class SellTicket {
    public static void main(String[] args) {
        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

//        SellTicket02 sellTicket02 = new SellTicket02();
//
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();

        //用synchronized进行同步
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();

    }
}

//实现接口方式，使用synchronized实现线程同步
class SellTicket03 implements Runnable {

    private static int ticketNum = 100;//多个线程共享 ticketNum
    private boolean loop = true;
    Object object = new Object();

    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize, 同步代码块，互斥锁还是在this对象
    public /*synchronized*/ void m1() {
        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }
        }
    }
    public static void m2() {
        synchronized (SellTicket03.class) {//这里填写this不好使，因为这是static 方法
            System.out.println("m2");
        }
    }
    public void sell() {
        synchronized (new Object()) {//这里如果添加new Object()，则线程访问的不是同一个对象，不能实现同步
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() { //同步方法，在同一时刻，只能有一个线程来执行 run 方法
        while (loop) {
            sell();
        }

    }


}

class SellTicket01 extends Thread {

    private static int ticketNum = 100;//多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if(ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));
        }
    }
}

class SellTicket02 implements Runnable {

    private static int ticketNum = 100;//多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if(ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));
        }
    }
}
