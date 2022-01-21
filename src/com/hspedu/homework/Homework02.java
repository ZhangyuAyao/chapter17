package com.hspedu.homework;

/**
 * @author: bytedance
 * @date: 2022/1/21
 * @description:
 */
public class Homework02 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread thread1 = new Thread(card);
        Thread thread2 = new Thread(card);

        thread1.setName("用户1");
        thread2.setName("用户2");
        thread1.start();
        thread2.start();

    }
}

class Card implements Runnable{
    private double money = 10000;


    @Override
    public void run() {
        while (true) {
            //解读：
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就回去争夺 this 对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块，执行完毕后，就释放 this 对象锁
            //4. 争夺不到 this 对象锁，就blocked, 准备继续争夺
            //5. this对象锁是非公平锁
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000， 当前余额为：" + money);
            }
            //休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
