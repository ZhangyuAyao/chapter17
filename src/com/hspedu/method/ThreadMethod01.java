package com.hspedu.method;

/**
 * @author: bytedance
 * @date: 2022/1/19
 * @description:
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();//启动子线程

        //主线程打印5 hi， 然后我就中断子线程的休眠
        for(int i = 0;i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 = " + t.getPriority());
        t.interrupt();//当执行到这里，就会中断 t线程的休眠

    }
}

class T extends Thread {
    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "   吃包子~~~~" + i);
            }
            System.out.println(Thread.currentThread().getName() + " 休眠中~~~~~~");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //当线程执行到一个interrupt异常时，会产生一个中断
                System.out.println(Thread.currentThread().getName() + "被 interrupt 了");
            }
        }
    }
}
