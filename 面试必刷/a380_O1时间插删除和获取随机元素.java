package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/01/03
 * @Description:
 */
public class a380_O1时间插删除和获取随机元素 {
    class S1 {
        class RandomizedSet {
            //记录 key - keyList index
            Map<Integer, Integer> record;
            List<Integer> keyList;
            final static Random r = new Random();

            public RandomizedSet() {
                record = new HashMap<>();
                keyList = new ArrayList<>();
            }

            public boolean insert(int val) {
                if (record.containsKey(val))
                    return false;
                record.put(val, record.size());
                keyList.addLast(val);
                return true;
            }

            public boolean remove(int val) {
                if (!record.containsKey(val))
                    return false;
                //2 7 5
                //2-0  5-2 7-1
                int keyListIndex = record.get(val); // 1
                int lastValue = keyList.getLast(); // 7
                keyList.set(keyListIndex, lastValue);
                record.put(lastValue, keyListIndex);
                keyList.removeLast();
                record.remove(val);
                return true;
            }

            public int getRandom() {
                return keyList.get(r.nextInt(keyList.size()));
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
