package com.hspedu.method;

/**
 * @author: bytedance
 * @date: 2022/1/20
 * @description:
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "吃了" + i + "个包子");
            if(i == 5) {
                System.out.println("主线程（小弟）让子线程（老大）先吃");
                t2.join();//这里相当于让t2线程先执行
                System.out.println(t2.getName() + "吃完了，main再接着吃");
            }
        }
    }
}


class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "吃了" + i + "个包子");
        }

    }
}