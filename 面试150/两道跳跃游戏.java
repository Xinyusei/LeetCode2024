package 面试150;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/21
 * @Description:
 */
public class 两道跳跃游戏 {
    /**
     * 跳跃游戏1 - DP / 贪心
     */
    class S1 {
        /**
         * DP
         */
        class Solution1 {
            public boolean canJump(int[] nums) {
                int n = nums.length;
                boolean[] f = new boolean[n];
                f[0] = true;
                for (int i = 0; i < n; i++) {
                    if (!f[i])
                        continue;
                    for (int step = 0; step <= nums[i] && i + step < n; step++) {
                        f[i + step] = true;
                    }
                }
                return f[n - 1];
            }
        }

        /**
         * 贪心
         */
        class Solution2 {
            public boolean canJump(int[] nums) {
                int n = nums.length, farthest = 0;
                for (int i = 0; i < n - 1; i++) {
                    farthest = Math.max(farthest, nums[i] + i);

                    if (farthest <= i)
                        return false;
                }
                return true;
            }
        }
    }


    /**
     * 45. 跳跃游戏 II
     */
    class S2 {
        /**
         * 贪心 - 方法1 从前往后找
         */
        class Solution1 {
            public int jump(int[] nums) {
                //用 i 和 end 标记了 可以选择 的跳跃步数 - end表示当前能跳的边界
                // farthest 标记了所有选择 [i..end] 中能够跳到的最远距离，jumps 记录跳跃次数。
                int n = nums.length, end = 0, farthest = 0, jumps = 0;
                for (int i = 0; i < n - 1; i++) {
                    farthest = Math.max(farthest, nums[i] + i);
                    if (end == i) {
                        jumps++;
                        end = farthest;
                    }
                }
                return jumps;
            }
        }

        /**
         * 贪心2 - 从后往前找
         */
        class Solution2 {
            //我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。
            //然后继续找上上个位置，最后到了第 0 个位置就结束了。
            //!至于离它最远的位置，其实我们从左到右遍历数组，第一个满足的位置就是我们要找的。!
            public int jump(int[] nums) {
                int jumps = 0, n = nums.length, pos = n - 1;
                while (pos != 0) { //是否到达起点
                    for (int i = 0; i < pos; i++) {
                        if (nums[i] >= pos - i) {
                            jumps++;
                            pos = i;
                            break;
                        }
                    }
                }
                return jumps;
            }
        }


        /**
         * 朴素 DP
         */
        class Solution3 {
            public int jump(int[] nums) {
                int n = nums.length;
                int[] f = new int[n];
                Arrays.fill(f, 1, n, n);
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] >= i - j)
                            f[i] = Math.min(f[j] + 1, f[i]);
                    }
                }
                return f[n - 1];
            }
        }

        /**
         * DP + 贪心 + 双指针
         */
        class Solution4 {
            public int jump(int[] nums) {
                int n = nums.length;
                int[] f = new int[n];
                //f[i] 表示跳到索引为i的位置所需要的最小次数
                //当我们要求某一个 f[i] 的时候，我们需要找到最早能够经过一步到达 i 点的 j 点。贪心的来取 ： 每次取离 i 最远的j 的来更新f[i]
                for (int i = 1, j = 0; i < n; i++) {
                    while (nums[j] < i - j) j++;
                    f[i] = f[j] + 1;
                }
                return f[n - 1];
            }
        }
    }
}



