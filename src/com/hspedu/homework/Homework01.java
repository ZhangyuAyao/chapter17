package com.hspedu.homework;

import java.util.Scanner;

/**
 * @author: bytedance
 * @date: 2022/1/20
 * @description:
 */
public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();

    }
}

class T1 extends Thread {
    private static boolean loop = true;
    @Override
    public void run() {
        while(loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setLoop(boolean loop) {
        T1.loop = loop;
    }
}

class T2 extends Thread {
    private Scanner scanner = new Scanner(System.in);
/*    private T1 t1;

    public T2(T1 t1) {
        this.t1 = t1;
    }*/

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令(Q)退出");
            if (scanner.next().equals("Q")) {
                T1.setLoop(false);
                break;
            }
        }
    }
}
