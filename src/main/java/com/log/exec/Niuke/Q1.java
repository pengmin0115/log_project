package com.log.exec.Niuke;

/**
 * @author pengmin
 * @date 2021/3/10 21:48
 *
 * 在进行对象赋值操作的时候,是引用传递的关系;都是指向同1个对象;
 */

public class Q1 {

    public static void main(String[] args) {
        float[] f1 = new float[2];
        float[] f2 = f1;
        f2[0] = 10f;
        for (float v : f1) {
            System.out.println(v);
        }
    }
}
