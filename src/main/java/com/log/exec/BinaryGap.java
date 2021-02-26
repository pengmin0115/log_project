package com.log.exec;

/**
 * @author pengmin
 * @date 2021/2/25 15:01
 */

public class BinaryGap {

    /**
     * 给定一个正整数 n，找到并返回 n 的二进制表示中两个相邻 1之间的最长距离 。如果不存在两个相邻的 1，返回 0 。
     * <p>
     * 注意点：可以通过Integer进行进制间的转换, char型变量进行比较时,记得加' '!
     */

    public static int calculateGap(int num) {
        String binaryString = Integer.toBinaryString(num);
        char[] chars = binaryString.toCharArray();
        int maxGap = 0;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                maxGap = Math.max(i - last, maxGap);
                //maxGap = (i - last) > maxGap ? (i - last) : maxGap;
                last = i;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(calculateGap(22));
        System.out.println(calculateGap(5));
        System.out.println(calculateGap(6));
    }
}
