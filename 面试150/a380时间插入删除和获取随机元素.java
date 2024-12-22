package 面试150;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/22
 * @Description:
 */
public class a380时间插入删除和获取随机元素 {
    /**
     * 设计数据结构 - 重点是如何将list的删除操作的时间复杂度降低为0(1)
     */
    static class S1 {
        class RandomizedSet {
            // 记录每个元素对应在 nums中的 索引
            private Map<Integer, Integer> record = new HashMap<>();
            // 存储元素索引
            private final List<Integer> nums;
            //随机函数
            private final Random r;

            public RandomizedSet() {
                record = new HashMap<>();
                nums = new LinkedList<>();
                r = new Random();
            }

            public boolean insert(int val) {
                if (record.containsKey(val))
                    return false;
                record.put(val, nums.size());
                nums.add(val);
                return true;
            }

            public boolean remove(int val) {
                if (!record.containsKey(val))
                    return false;
                //先拿到 val在 nums中的索引
                int idx = record.get(val);
                //与最后一个元素交换位置
                //1:0,3:1,5:2,6:3
                //1,3,5,6
                int last = nums.getLast();
                nums.set(idx, last);
                nums.removeLast();
                record.put(last, idx);
                //1,6,5
                //1:0,5:2,6:1
                record.remove(val);
                return true;

            }

            public int getRandom() {
                return nums.get(r.nextInt(nums.size()));
            }
        }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
    }
}
