package 面试150;

/**
 * @Author: ZJX
 * @Date: 2024/12/19
 * @Description:
 */
public class a169多数元素 {
    //方法1 - 哈希表计数
    //方法2 - 排序

    //方法3 - 摩尔投票算法 - 将众数记为+1，其他数记为-1，将他们全部加起来肯定大于0
    //维护一个候选众数 candidate 和 它出现的次数 count 。
    //遍历数组每一个元素，对于每个元素，如果在判断之前 count为0，则将x设置为candidate
    //判断 ： 如果 x == candidate，则 count+1, 否则 count - 1
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = Integer.MIN_VALUE;

            for (int x : nums) {
                if (count == 0) {
                    candidate = x;
                }
                count += x == candidate ? 1 : -1;
            }
            return candidate;
        }
    }
}
