package 面试必刷;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/22
 * @Description:
 */
public class a238除自身以外数组的乘积 {
    /**
     * 前后缀分解
     */
    class S1 {
        class Solution {
            public int[] productExceptSelf(int[] nums) {
                //1,1,2,6,24
                int n = nums.length;
                int[] fp = new int[n], fn = new int[n];
                fp[0] = 1;
                fn[n - 1] = nums[n - 1];
                for (int i = 1; i < n; i++)
                    fp[i] = fp[i - 1] * nums[i];
                for (int i = n - 2; i >= 0; i--)
                    fn[i] = fn[i + 1] * nums[i];

                System.out.println("fp = " + Arrays.toString(fp));
                System.out.println("fn = " + Arrays.toString(fn));
                nums[0] = fn[1];
                nums[n - 1] = fp[n - 2];
                for (int i = 2; i < n - 1; i++) {
                    nums[i] = fp[i - 1] * fn[i + 1];
                }
                return nums;
            }
        }
    }


    /**
     * 优化
     */
    class S2 {
        class Solution {
            public int[] productExceptSelf(int[] nums) {
                int n = nums.length;
                int[] f = new int[n];
                Arrays.fill(f, 1);

                int l = 1;
                //1,1,2,6
                for (int i = 0; i < n; i++) {
                    f[i] *= l;
                    l *= nums[i];
                }
                System.out.println(Arrays.toString(f));
                int r = 1;
                for (int i = n - 1; i >= 0; i--) {
                    f[i] *= r;
                    r *= nums[i];
                }
                System.out.println(Arrays.toString(f));
                return f;
            }
        }
    }
}
