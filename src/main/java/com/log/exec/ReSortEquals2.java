package com.log.exec;

import java.util.Arrays;

/**
 * @author pengmin
 * @date 2021/2/25 15:24
 */

public class ReSortEquals2 {

    /**
     * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
     * <p>
     * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
     * <p>
     * num ∈ [1, 10^9]
     */

    public static boolean reorderedPowerOf2(int num) {
        int i = 1;
        while (i < Math.pow(10, 9) + 1) {
            char[] chars = String.valueOf(i).toCharArray();
            Arrays.sort(chars);
            char[] targetChars = String.valueOf(num).toCharArray();
            Arrays.sort(targetChars);
            if (String.valueOf(chars).equals(String.valueOf(targetChars))) {
                return true;
            }
            i = i << 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ReSortEquals2.reorderedPowerOf2(160));
    }
}
