package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

/**
 * 2024. 考试的最大困扰度
 * https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/
 */
public class a2024考试的最大困扰度 {
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            //问题转化： 最多允许出现K个不相同的T/F对的子数组的长度
            char[] s = answerKey.toCharArray();
            // 用数组记录 T  F 出现的次数
            int[] window = new int[256];
            int ret = 0;
            for (int lo = 0, hi = 0; hi < s.length; hi++) {
                window[s[hi]]++;
                while (Math.min(window['T'], window['F']) > k)
                    window[s[lo++]]--;
                ret = Math.max(ret, hi - lo + 1);
            }
            return ret;
        }
    }
}
