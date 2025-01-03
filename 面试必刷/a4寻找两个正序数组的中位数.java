package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class a4寻找两个正序数组的中位数 {
    /**
     * 二分 + 两个有序数组中第 k 小的元素
     */
    class S1 {
        class Solution {
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int m = nums1.length, n = nums2.length, len = m + n;
                //如果是奇数个数
                if ((len & 1) == 1)
                    return findTheKthNum(nums1, nums2, len / 2 + 1);
                    //如果是偶数个数
                else
                    return 0.5 * (findTheKthNum(nums1, nums2, len / 2) + findTheKthNum(nums1, nums2, len / 2 + 1));
            }

            //去找 第 k 小的数
            private int findTheKthNum(int[] nums1, int[] nums2, int k) {
                /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
                 * 这里的 "/" 表示整除
                 * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
                 * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
                 * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
                 * 这样 pivot 本身最大也只能是第 k-1 小的元素
                 * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
                 * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
                 * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
                 */
                int len1 = nums1.length, len2 = nums2.length;
                int idx1 = 0, idx2 = 0;

                while (true) {
                    //1.考虑边界
                    //1.1 说明 nums1 的所有元素已经被排除，此时返回 nums2[idx2 + k - 1]，即第 k 个元素直接在 nums2 中。
                    if (idx1 == len1)
                        return nums2[idx2 + k - 1];
                    //1.2 同1
                    if (idx2 == len2)
                        return nums1[idx1 + k - 1];
                    //1.3 如果 k == 1，说明我们已经找到了第 1 小的元素，此时直接返回 nums1[idx1] 和 nums2[idx2] 中较小的那个。
                    if (k == 1)
                        return Math.min(nums1[idx1], nums2[idx2]);
                    //2.正常情况
                    //2.1 分别取两个数组中找各自的第[k / 2 - 1]小的元素
                    int half = k >> 1;
                    int newIdx1 = Math.min(idx1 + half, len1) - 1;
                    int newIdx2 = Math.min(idx2 + half, len2) - 1;

                    //nums1[newIdx1] 及其之前的元素不可能是第 k 小的元素，因此可以跳过这些元素
                    if (nums1[newIdx1] <= nums2[newIdx2]) {
                        k -= (newIdx1 - idx1 + 1); //减去删除的数的个数
                        idx1 = newIdx1 + 1; //跳过这些数
                    } else {
                        k -= (newIdx2 - idx2 + 1);
                        idx2 = newIdx2 + 1;
                    }
                }
            }
        }
    }
}
