package Type_.滑动窗口与双指针;

public class a396旋转函数 {
    /**
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        /**
         * 前缀和+滑动窗口
         */
        int n = nums.length, cur = 0;
        int[] extend = new int[2 * n + 1];
        int[] pre = new int[2 * n + 1];
        //扩展数组
        for (int i = 0; i < extend.length; i++) {
            extend[i] = nums[i % n];
        }
        //构造前缀和
        for (int i = 1; i <= 2 * n; i++) {
            pre[i] = pre[i - 1] + extend[i - 1];
        }
        //起始cur
        for (int i = 0; i < n; i++) {
            cur += nums[i] * i;
        }
        int ans = cur;
        for (int i = 1, j = i + n - 1; i < n; i++, j++) {
            cur -= pre[j] - pre[i];
            cur += extend[j] * (n - 1);
            if (cur > ans) ans = cur;
        }
        return ans;
    }
    /**
     * O(n²)-超时
     */

//    public int maxRotateFunction(int[] nums) {
//        int ans = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int f = 0;
//            for (int j = 0; j < nums.length; j++) {
//                f += nums[j] * ((j + i) % nums.length);
//            }
//            ans = Math.max(ans, f);
//        }
//        return ans;
//    }
}
