package com.hspedu.ticket;

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

        SellTicket02 sellTicket02 = new SellTicket02();

        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();

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
