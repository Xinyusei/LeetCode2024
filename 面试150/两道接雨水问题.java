package 面试150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: ZJX
 * @Date: 2024/12/24
 * @Description:
 */
public class 两道接雨水问题 {
    /**
     * 42. 接雨水
     * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
     */
    class type1 {
        /**
         * 前缀&后缀最大值数组
         */
        class S1 {
            class Solution {
                public int trap(int[] height) {
                    int n = height.length;
                    //leftMax表示 i 左侧最大柱子高度,rightMax 表示 i 右侧最大柱子高度
                    int[] leftMax = new int[n], rightMax = new int[n];
                    leftMax[0] = height[0];
                    for (int i = 1; i < n; i++) {
                        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
                    }
                    rightMax[n - 1] = height[n - 1];
                    for (int i = n - 2; i >= 0; i--) {
                        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
                    }
                    int res = 0;
                    for (int i = 0; i < n; i++) {
                        int min = Math.min(leftMax[i], rightMax[i]);
                        res += min - height[i];
                    }
                    return res;
                }
            }
        }

        /**
         * 优化 - 空间复杂度0(1)
         */
        class S2 {
            class Solution {
                public int trap(int[] height) {
                    int n = height.length, lIdx = 0, rIdx = n - 1;
                    int l_max = 0, r_max = 0, res = 0;
                    //l_max 代表 0...lIdx 柱子最大高度 r_max代表 rIdx...n-1柱子最大高度
                    //
                    while (lIdx <= rIdx) {
                        l_max = Math.max(l_max, height[lIdx]);
                        r_max = Math.max(r_max, height[rIdx]);
                        //此时并不关心 lIdx...n-1的柱子最大高度,因为肯定>=l_max,反正最后都是l_max-当前柱子高度
                        if (l_max <= r_max)
                            res += l_max - height[lIdx++];
                            //此时并不关心 0...rIdx的柱子最大高度,因为肯定>=r_max,最后都是r_max-当前柱子高度
                        else
                            res += r_max - height[rIdx--];

                    }
                    return res;
                }
            }
        }


        /**
         * 单调栈解法 - 比较难想到
         */
        class S3 {
            class Solution {
                public int trap(int[] height) {
                    //单调不增栈，height元素作为右墙依次入栈
                    //出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水
                    Deque<Integer> stack = new ArrayDeque<>();
                    int res = 0;
                    for (int i = 0; i < height.length; i++) {
                        //栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了
                        while (!stack.isEmpty() && height[i] >= height[stack.getFirst()]) {
                            //低洼处弹出，尝试结算此低洼处能积攒的雨水
                            int bottomIdx = stack.removeFirst();
                            // 但是此时没有左边墙壁了，没法搭建水洼
                            if (stack.isEmpty())
                                break;
                            //有左边墙壁，计算高度

                            //左边墙壁索引
                            int left = stack.getFirst();
                            int leftHeight = height[left], rightHeight = height[i], bottomHeight = height[bottomIdx];
                            res += (i - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
                        }
                        stack.addFirst(i);
                    }
                    return res;
                }
            }
        }
    }

    /**
     * 11. 盛最多水的容器
     * https://leetcode.cn/problems/container-with-most-water/
     */
    class type2 {
        /**
         * 面积由短板决定
         */
        class Solution {
            public int maxArea(int[] height) {
                int left = 0, right = height.length - 1,res = 0;
                while (left < right) {
                    int l = height[left], r = height[right], s = (right - left) * Math.min(l, r);
                    res = Math.max(res, s);
                    if (l <= r) {
                        left++;
                    } else {
                        right--;
                    }
                }
                return res;
            }
        }
    }
}
