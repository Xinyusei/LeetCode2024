package Type_.滑动窗口与双指针.单序双指针.一_相向双指针;

/**
 * @Author: ZJX
 * @Date: 2025/01/26
 * @Description:
 */
public class a11盛最多水的容器 {
    class S1 {
        class Solution {
            public int maxArea(int[] height) {
                int left = 0, right = height.length - 1;
                int res = 0;
                while (left < right) {
                    int lh = height[left];
                    int rh = height[right];
                    res = Math.max(res, (rh - lh) * Math.min(lh, rh));
                    if (lh < rh)
                        left++;
                    else
                        right--;
                }
                return res;
            }
        }
    }
}
