package 面试150;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/24
 * @Description:
 */
public class a134加油站 {
    /**
     * 借助画图理解
     */
    class S1 {
        class Solution {
            public int canCompleteCircuit(int[] gas, int[] cost) {
                //考虑环形数组f[i] = gas[i] - cost[i]，我们需要判断这个环形数组中是否能够找到一个起点 start，使得从这个起点开始的累加和一直大于等于 0。
                int n = gas.length;
                //相当于图像中的坐标点(y,x)以及最低点

                //-2,-2,-2,3,3
                int sum = 0, start = 0, minSum = 0;
                for (int i = 0; i < n; i++) {
                    sum += gas[i] - cost[i];
                    if (sum < minSum) {
                        //经过了第i个站点,sum达到新低,更新sum - 相当于不断去更新图像的最低点
                        minSum = sum;
                        start = i + 1;
                    }
                }
                if (sum < 0)
                    // 总油量小于总的消耗，无解
                    return -1;
                // 环形数组特性
                return start == n ? 0 : start;
            }
        }
    }


    /**
     * 贪心 + 推导
     */
    class S2 {
        /**
         * 枚举起点start，检查每个起点能否绕一圈：
         * 1. 如果start可以往后走n步，那就可以绕一圈，返回start即可。
         * 2. 如果start只能走step步（其中step<n）到某个点j，那么下一个起点只能从start+step+1开始尝试。
         * 说明：从中间的某个点k开始也是不可能跨过j点的，因为从start可以到k点，说明start到k可以带大于等于0的油量过来。
         * 带了油过来都跨越不了j点，那以k为起点肯定更加跨越不了j点。
         */
        class Solution {
            public int canCompleteCircuit(int[] gas, int[] cost) {
                int n = gas.length;
                for (int start = 0; start < n; ) {
                    int rest = 0, step = 0;
                    while (step < n) {
                        int nex = (start + step) % n;
                        rest += gas[nex] - cost[nex];
                        if (rest < 0)
                            break;
                        step++;
                    }
                    if (step == n)
                        return start;
                    start += step + 1;
                }
                return -1;
            }
        }
    }
}
