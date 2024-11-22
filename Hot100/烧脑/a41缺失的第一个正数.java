package Hot100.烧脑;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a41缺失的第一个正数 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            //1. 对于对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1]
            //我们对数组进行遍历，对于遍历到的数 x，如果它在 [1,N] 的范围内，那么就将数组中的第 x−1 个位置（注意：数组下标从 0 开始）打上「标记」。
            // 在遍历结束之后，如果所有的位置都被打上了标记，那么答案是 N+1，否则答案是最小的没有打上标记的位置加 1。
            //我们只在意 [1,N] 中的数，我们可以先对数组进行遍历，把不在 [1,N] 范围内的数修改成任意一个大于 N 的数（例如 N+1）。
            // 这样一来，数组中的所有数就都是正数了，因此我们就可以将「标记」表示为「负号」。
            int n = nums.length;
            //第一次遍历:对所有负数的数进行标记设置为n+1
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0)
                    nums[i] = n + 1;
            }
            System.out.println(Arrays.toString(nums));
            //现在所有的数处于[1,N+1]了,然后现在就是标记哪些数存在了 - 相当于哈希表
            //比如[3,4,5,1],就把3对应的位置-索引为2,标记为当前索引对应值的负数即-5
            //4对应的位置,索引为3的数1标记为-1
            //5为N+1不管,1对应的位置-索引0的数3标记为-3
            //所以遍历为第一个不为负数的索引,就返回索引+1.否则返回N+1
            for (int i = 0; i < n; i++) {
               /* System.out.println("nums[] = " + nums[i]);
                if (nums[i] <= n)
                    nums[nums[i] - 1] = -1;*/
                //注意一种情况：比如3对应的索引为2,标记为-1，当遍历到这个索引为2的位置的时候其nums[i]为负数，不能表示索引
                int num = Math.abs(nums[i]);
                //当前的数存在,标记
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            System.out.println(Arrays.toString(nums));

            //1,2,4


            //3,4,5,1
            //-1,4,-1,-1

            //6,6,6,6,6
            //6,6,6,6,6

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0)
                    return i + 1;
            }
            return n + 1;
        }
    }
}
