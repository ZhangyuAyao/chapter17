package com.hspedu;

/**
 * @author: bytedance
 * @date: 2022/1/19
 * @description:
 */
public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的cpu数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前有cpu 个数=" + cpuNums);

    }
}
