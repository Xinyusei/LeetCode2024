package 面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class 两道三数之和 {
    /**
     * 15. 三数之和 - 排序 + 双指针
     */
    class S1 {
        class Solution {
            public List<List<Integer>> threeSum(int[] nums) {
                Arrays.sort(nums);
                List<List<Integer>> res = new ArrayList<>();
                for (int i = 0; i < nums.length - 2; ) {
                    int target = -nums[i];
                    int j = i + 1, k = nums.length - 1;
                    while (j < k) {
                        int leftVal = nums[j], rightVal = nums[k];
                        if (leftVal + rightVal == target) {
                            res.add(List.of(nums[i], nums[j], nums[k]));
                            while (j < k && leftVal == nums[j]) j++;
                            while (j < k && rightVal == nums[k]) k--;
                        } else if (leftVal + rightVal < target) {
                            while (j < k && leftVal == nums[j]) j++;
                        } else {
                            while (j < k && rightVal == nums[k]) k--;
                        }
                    }
                    while (i < nums.length - 2 && nums[i] == -target)
                        i++;
                }
                return res;
            }
        }
    }


    /**
     * 16. 最接近的三数之和
     */
    class S2 {
        class Solution {
            public int threeSumClosest(int[] nums, int target) {
                Arrays.sort(nums);
                int diff = Integer.MAX_VALUE; //表示三数之和与target的差
                int res = 0;
                int n = nums.length;
                //枚举第一个数
                for (int i = 0; i < n - 2; ) {
                    int v = nums[i];
                    //双指针枚举 第二个数 和 第三个数
                    int j = i + 1, k = n - 1;
                    while (j < k) {
                        int leftVal = nums[j], rightVal = nums[k];
                        if (v + leftVal + rightVal == target)
                            return target;
                        else if (v + leftVal + rightVal > target) {
                            if (v + leftVal + rightVal - target <= diff) {
                                diff = v + leftVal + rightVal - target;
                                res = v + leftVal + rightVal;
                            }
                            //将和缩小
                            while (j < k && rightVal == nums[k]) k--;
                        } else {
                            if (target - (v + leftVal + rightVal) <= diff) {
                                diff = target - (v + leftVal + rightVal);
                                res = v + leftVal + rightVal;
                            }
                            //将和缩小
                            while (j < k && leftVal == nums[j]) j++;
                        }
                    }
                    //保证和上次枚举的元素不同
                    while (i < n - 2 && v == nums[i]) i++;
                }
                return res;
            }
        }
    }
}
