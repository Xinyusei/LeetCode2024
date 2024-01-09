package labuladong.数组.双指针;

public class a26删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        //我的想法：双指针，当快右边的指针与左边指针指向的值相同，右边需要一直移动直到遇见不同的值。
        //此时，左指针移动，将右边的值给换过来，保证了不重复。右边指针继续移动
        //上述思路首先是站在右边指针指向值与左边相同的情况下，如果先考虑不同则交换，反而比较简单。
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            int cur = nums[left];
            while (right < n && nums[right] == cur)
                right++;
            if (right < n && left < n - 1) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    //东哥的想法-
    public int removeDuplicates2(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left++;
    }
}