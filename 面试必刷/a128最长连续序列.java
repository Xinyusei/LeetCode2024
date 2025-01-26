package 面试必刷;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/29
 * @Description:
 */
public class a128最长连续序列 {
    class S1 {
        class Solution {
            public int longestConsecutive(int[] nums) {
                // 转化成哈希集合，方便快速查找是否存在某个元素
                Set<Integer> seen = new HashSet<>();
                for (int x : nums) {
                    seen.add(x);
                }
                int res = 0;
                //这里用seen 比 nums更快 - 优化点
                for (int x : seen) {
                    if (seen.contains(x - 1))
                        // x 不是连续子序列的第一个，跳过。以 x - 1 为起点计算出的序列长度，一定比以 x 为起点计算出的序列长度要长！
                        continue;
                    // x 是连续子序列的第一个，开始向上计算连续子序列的长度
                    int curNum = x + 1;
                    while (seen.contains(curNum)) {
                        curNum += 1;
                    }
                    // 更新最长连续序列的长度
                    res = Math.max(res, curNum - x);
                }
                return res;
            }
        }
    }
}
