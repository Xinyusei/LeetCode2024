package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2025/02/10
 * @Description:
 */
public class a189轮转数组 {
    class S1{
        class Solution {
            public void rotate(int[] nums, int k) {
                //7654321
                //5671234
                k %= nums.length;
                //1.全部翻转
                reverse(nums,0,nums.length - 1);
                //2.翻转前k个
                reverse(nums,0, k - 1);
                //3.翻转后n-k个
                reverse(nums,k,nums.length - 1);
            }

            public void reverse(int[] nums,int lo,int hi){
                while(lo < hi){
                    int temp = nums[lo];
                    nums[lo] = nums[hi];
                    nums[hi] = temp;
                    lo++;
                    hi--;
                }
            }

        }
    }
}
