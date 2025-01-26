package Type_.滑动窗口与双指针.单序双指针.一_相向双指针;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/01/26
 * @Description:
 */
public class a42接雨水 {
    /**
     * 预处理 （dp)
     */
    class S1_1 {
        class Solution {
            public int trap(int[] height) {
                int n = height.length;
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
                    res += Math.min(leftMax[i], rightMax[i]) - height[i];
                }
                return res;
            }
        }
    }

    /**
     * 预处理的改进
     */
    class S1_2 {
        class Solution {
            public int trap(int[] height) {

                int n = height.length;
                int leftMax = 0, rightMax = 0;
                int res = 0;
                for (int i = 0, j = n - 1; i < j; ) {
                    //不断更新 leftMax和rightMax
                    leftMax = Math.max(leftMax, height[i]);
                    rightMax = Math.max(rightMax, height[j]);
                    //此时并不关心 lIdx...n-1的柱子最大高度,因为肯定>=l_max,反正最后都是l_max-当前柱子高度

                    if (leftMax <= rightMax) {
                        res += leftMax - height[i];
                        // 将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；
                        i++;
                    } else {
                        res += rightMax - height[j];
                        j--;
                    }
                }
                return res;
            }
        }
    }

    class S2_1 {
        class Solution {
            public int trap(int[] height) {
                //单调不增栈，height元素作为右墙依次入栈
                //出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水

                List<Integer> stack = new ArrayList<>();
                int n = height.length;
                int res = 0;
                for (int i = 0; i < n; i++) {
                    //栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了

                    while (!stack.isEmpty() && height[i] > height[stack.getLast()]) {
                        //低洼处弹出，尝试结算此低洼处能积攒的雨水

                        int bottomIdx = stack.removeLast();
                        // 但是此时没有左边墙壁了，没法搭建水洼

                        if (stack.isEmpty())
                            break;
                        //有左边墙壁，计算高度

                        int leftIdx = stack.getLast();
                        //宽
                        int w = i - leftIdx - 1;
                        //高
                        int h = Math.min(height[leftIdx], height[i]) - height[bottomIdx];
                        res += w * h;

                    }
                    stack.addLast(i);
                }
                return res;
            }
        }
    }
}
