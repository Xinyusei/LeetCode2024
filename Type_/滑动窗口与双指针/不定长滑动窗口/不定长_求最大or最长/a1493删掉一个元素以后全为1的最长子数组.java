package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 */
public class a1493删掉一个元素以后全为1的最长子数组 {
    class Solution {
        public int longestSubarray(int[] nums) {
            //找到最多只包含一个0的子数组的最大长度
            int cnt = 0;
            int ret = 0;
            int lo = 0, hi = 0;
            for (; hi < nums.length; hi++) {
                if (nums[hi] == 0)
                    cnt++;
                if (cnt > 1) {
                    //保存上一步的结果
                    ret = Math.max(ret, hi - lo - 1);
                    while (cnt > 1) {
                        if (nums[lo++] == 0)
                            cnt--;
                    }
                }
                //需要缩减窗口
            }
            return Math.max(ret, hi - lo - 1);
        }
    }
}
