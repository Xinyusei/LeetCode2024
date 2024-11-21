package Hot100.哈希;

/**
 * @Author: ZJX
 * @Date: 2024/11/21
 * @Description:
 */
public class a11盛最多水的容器 {
    class Solution1 {
        //直观的想法:遍历每一个线,然后以这条线为基础,继续遍历其他线
        //O(n ^ 2)
        public int maxArea(int[] height) {
            //y
            int ret = 0;
            int n = height.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    ret = Math.max(ret, (j - i) * Math.min(height[i], height[j]));
                }
            }
            return ret;
        }
    }

    class Solution2 {
        //直观的想法:遍历每一个线,然后以这条线为基础,继续遍历其他线
        //O(n ^ 2)
        public int maxArea(int[] height) {
            int ret = Integer.MIN_VALUE;
            for (int lo = 0, hi = height.length - 1; lo < hi; ) {
                int l = height[lo], r = height[hi], s = Math.min(l, r) * (hi - lo);
                ret = Math.max(ret, s);
                if (l < r)
                    lo++;
                else
                    hi--;
            }
            return ret;
        }
    }
}
