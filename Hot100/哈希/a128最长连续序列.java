package Hot100.哈希;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/11/21
 * @Description:
 */
public class a128最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            //1. 排序 + 双指针

            //2. 数组计数
            Set<Integer> record = new HashSet<>();
            int miv = Integer.MAX_VALUE;
            int mav = Integer.MIN_VALUE;
            for (int num : nums) {
                record.add(num);
                miv = Math.min(miv, num);
                mav = Math.max(mav, num);
            }
            //1 2 3 4 100 200
            int ret = 1;
            for (int lo = miv, hi = miv; hi <= mav; hi++) {
                if (record.contains(hi) && record.contains(hi + 1))
                    continue;
                ret = Math.max(hi - lo + 1, ret);
                lo = hi + 1;
            }
            return ret;
        }


    }

    class Solution2 {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;

            // 转化成哈希集合，1.方便快速查找是否存在某个元素 2.去重
            Set<Integer> record = new HashSet<>();
            for (int num : nums) {
                record.add(num);
            }
            int ret = 0;
            for (int v : record) {
                //说明当前的数不是连续子序列的第一个,跳过
                if (record.contains(v - 1)) {
                    continue;
                }
                //当前的数是连续子序列的第一个,开始向上计算连续子序列的长度
                int crtNum = v;
                int crtLs = 1;

                while (record.contains(crtNum + 1)) {
                    crtNum++;
                    crtLs++;
                }
                //退出了while循环,更新最长连续子序列的长度
                ret = Math.max(ret, crtLs);
            }
            return ret;
        }
    }
}
