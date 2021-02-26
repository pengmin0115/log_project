package com.log.exec;

import java.util.Arrays;

/**
 * @author pengmin
 * @date 2021/2/25 15:48
 */

public class Greed {

    /**
     * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
     * <p>
     * 返回 A 的任意排列，使其相对于 B 的优势最大化。
     */

    public static int[] advantageCount(int[] a, int[] b) {
        int length = a.length;
        int[] temp = new int[length];
        int[] indexArray = new int[length];
        Arrays.sort(a);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > b[i] && notInArray(j, indexArray)) {
                    temp[i] = a[j];
                    addIndex(indexArray, j);
                    break;
                }
            }
            if (temp[i] == 0) {
                for (int j = 0; j < a.length; j++) {
                    if (notInArray(j, indexArray)) {
                        temp[i] = a[j];
                        addIndex(indexArray, j);
                        break;
                    }
                }
            }
        }
        return temp;
    }

    public static boolean notInArray(int num, int[] arrays) {
        num = num == 0 ? -1 : num;
        for (int array : arrays) {
            if (array == num) {
                return false;
            }
        }
        return true;
    }

    public static void addIndex(int[] arrays, int index) {
        // 手动将0索引位置的索引改为-1;
        if (index == 0) {
            index = -1;
        }
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                arrays[i] = index;
                break;
            }
        }
    }

    public static void main(String[] args) {
        //int[] a = new int[]{2, 7, 11, 15}, b = new int[]{1, 10, 4, 11};
        int[] a = new int[]{12, 24, 8, 32}, b = new int[]{13, 25, 32, 11};
        int[] count = advantageCount(a, b);
        for (int c : count) {
            System.out.println(c);
        }
    }

}
