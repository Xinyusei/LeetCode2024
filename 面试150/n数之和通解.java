package 面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class n数之和通解 {
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

    /**
     * 四数之和
     */
    class S3 {
        class Solution {
            public List<List<Integer>> fourSum(int[] nums, int target) {
                Arrays.sort(nums);
                List<List<Integer>> res = new ArrayList<>();
                for (int i = 0; i < nums.length - 3; ) {
                    int v = nums[i];
                    List<List<Integer>> triples = threeSumTarget(nums, i + 1, target - v);
                    //System.out.println("triples = " + triples);
                    //System.out.println("v = " + v);
                    for (List<Integer> triple : triples) {
                        ArrayList<Integer> list = new ArrayList<>(triple);
                        list.add(v);
                        res.add(list);
                    }
                    while (i < nums.length - 3 && nums[i] == v) i++;
                }
                return res;
            }

            public List<List<Integer>> threeSumTarget(int[] nums, int start, long t) {
                int n = nums.length;
                List<List<Integer>> res = new ArrayList<>();
                for (int i = start; i < nums.length - 2; ) {
                    int v = nums[i];
                    long target = t - v;
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
                    while (i < nums.length - 2 && nums[i] == v)
                        i++;
                }
                return res;
            }
        }
    }


    /**
     * 通用框架 - n 数之和
     */
    class S4 {
        // 注意：调用这个函数之前一定要先给 nums 排序
        // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
        List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
            int sz = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            //至少应该是两数之和 且数组大小不应该小于n
            if (n < 2 || sz < n) return res;
            if (n == 2) {
                int left = start, right = sz - 1;
                while (left < right) {
                    int leftVal = nums[left], rightVal = nums[right], sum = leftVal + rightVal;
                    if (sum == target) {
                        res.add(List.of(leftVal, rightVal));
                        while (left < right && nums[left] == leftVal) left++;
                        while (left < right && nums[right] == rightVal) right--;
                    } else if (sum > target) {
                        while (left < right && nums[right] == rightVal) right--;
                    } else
                        while (left < right && nums[left] == leftVal) left++;
                }

            }
            //n 大于 2
            else {
                for (int i = start; i < sz - n + 1; ) {
                    int baseVal = nums[i];
                    List<List<Integer>> subNSumTarget = nSumTarget(nums, n - 1, i + 1, target - baseVal);
                    for (List<Integer> list : subNSumTarget) {
                        ArrayList<Integer> arr = new ArrayList<>(list);
                        arr.add(baseVal);
                        res.add(arr);
                    }
                    while (i < sz - n + 1 && baseVal == nums[i]) i++;
                }
            }
            return res;
        }

        /**
         * 调用框架 - 四数之和
         *
         * @param nums
         * @param target
         * @return
         * @author ZJX
         * @date 2024/12/26
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return nSumTarget(nums, 4, 0, target);
        }

        /**
         * 调用框架 - 三数之和
         *
         * @param nums
         * @return
         * @author ZJX
         * @date 2024/12/26
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            return nSumTarget(nums, 3, 0, 0);
        }
    }
}
