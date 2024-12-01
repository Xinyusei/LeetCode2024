package 周赛.w426;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/01
 * @Description:
 */
public class a识别数组中的最大异常值 {
    class Solution {
        public int getLargestOutlier(int[] nums) {
            //n - 2个特殊数  ， 1个数为 特殊数的和 还有 1个为异常值，返回可能的最大异常值
            //即 选定某个数为 异常值，判断剩下 n - 1 个数中，是否有一个数是其余 n-2 个数的元素之和
            int sum = 0;
            HashMap<Integer, Integer> record = new HashMap<>();
            for (int v : nums) {
                sum += v;
                record.put(v, record.getOrDefault(v, 0) + 1);
            }
            int ret = Integer.MIN_VALUE;
            for (int v : nums) {
                //假定v是特殊元素
                int remain = sum - v;
                //如果remain是偶数,且 remain / 2在 `剩下`的 n - 1个数中,则当前v的就是一个异常值
                //这里 先排除当前的数 v 的干扰
                record.put(v, record.get(v) - 1);

                if ((remain & 1) == 0 && record.getOrDefault(remain / 2, 0) >= 1)
                    ret = Math.max(ret, v);

                //v记录+1
                record.put(v, record.get(v) + 1);

            }
            return ret;
            //[6,-31,50,-35,41,37,-42,13]
        }
    }
}
