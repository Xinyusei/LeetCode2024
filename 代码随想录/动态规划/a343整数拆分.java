package 代码随想录.动态规划;

import jdk.jfr.Description;

import java.lang.reflect.Array;
import java.util.Arrays;


public class a343整数拆分 {
    class Solution {
        public int integerBreak(int n) {
            int[] f = new int[n + 1];


            //f[i] 表示 正整数 i 拆分为 k 个正整数后 这些正整数的最大乘积
            f[1] = f[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    f[i] = Math.max(Math.max(f[i], j * (i - j)), j * f[i - j]);
                }
            }
            System.out.println(Arrays.toString(f));
            return f[n];
        }
    }
}


