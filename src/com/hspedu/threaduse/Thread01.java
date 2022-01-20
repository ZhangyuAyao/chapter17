package com.hspedu.threaduse;

/**
 * @author: bytedance
 * @date: 2022/1/19
 * @description: 通过继承Thread 类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        //创建一个Cat对象，可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
/*
        (1)
        public synchronized void start() {
            start0();
        }
        (2)
        //start0() 是本地方法，是JVM调用，底层是c/c++实现
        //真正实现多线程的效果，是start0(), 而不是 run
        private native void start0();

*/
        //说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        //这时，主线程和子线程是交替执行
        System.out.println("主线程继续执行 " + Thread.currentThread().getName());//名字main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}
/*
1. 当一个类继承了 Thread 类，该类就可以当做线程使用
2. 我们会重写 run方法，实现自己的业务代码
3. run Thread 类实现了 Runnable 接口的 run 方法
 */
class Cat extends Thread {

    int times = 0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑

        while (true) {
            System.out.println("喵喵，我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 8) {
                break;//当times 到8， 退出while， 这时线程也就退出
            }
        }
    }
}
