package Ev2024_1;

import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 * https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/?envType=daily-question&envId=2024-01-25
 */
public class a1_25ez {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (getPos(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    private int getPos(int num) {
        int pos = 0;
        while (num > 0) {
            /*
            当x = 2^n(n为自然数)时，
            a % x = a & (x  - 1 )
            */
            if ((num & 1) != 0) //等价于 num % 2
                pos++;
            num >>= 1;
        }
        return pos;

    }

    public int sumIndicesWithKSetBits2(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
