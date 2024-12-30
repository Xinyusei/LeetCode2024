package 面试150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/30
 * @Description:
 */
public class a228汇总区间 {

    /**
     * 不太容易出错的分组循环
     */
    class S2 {
        class Solution {
            public List<String> summaryRanges(int[] nums) {
                List<String> res = new ArrayList<>();
                int n = nums.length, i = 0;
                while (i < n) {
                    //low 指向起点
                    int low = i;
                    i++;
                    while (i < n && nums[i] == nums[i - 1] + 1)
                        i++;
                    //high 指向终点
                    int high = i - 1;
                    StringBuilder sb = new StringBuilder(nums[low] + "");
                    if (low < high) {
                        sb.append("->").append(nums[high]);
                    }
                    res.add(sb.toString());
                }
                return res;
            }
        }
    }

    class S1 {
        class Solution {
            public List<String> summaryRanges(int[] nums) {

                int n = nums.length;
                List<String> res = new ArrayList<>();
                if (n == 0)
                    return res;
                int lo = 0;
                for (int hi = 0; hi < n; hi++) {
                    //hi 向后遍历
                    if (hi + 1 < n && nums[hi + 1] - 1 != nums[hi]) {
                        //将当前区间写入
                        StringBuilder sb = new StringBuilder();
                        sb.append(nums[lo]);
                        if (hi != lo) {
                            sb.append("->").append(nums[hi]);
                        }
                        res.add(sb.toString());
                        lo = hi + 1;
                    }
                }
                return res;
            }
        }
    }
}
