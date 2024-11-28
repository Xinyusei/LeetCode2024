package Hot100.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/11/27
 * @Description:
 */
public class a763划分字母区间 {
    class Solution1 {
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            for (int i = 0; i < s.length(); i++)
                //记录 最后一次出现的位置
                last[s.charAt(i) - 'a'] = i;

            //System.out.println(Arrays.toString(last));
            List<Integer> res = new ArrayList<>();
            int start = 0, end = 0;
            //上述做法使用贪心的思想寻找每个片段可能的最小结束下标，因此可以保证每个片段的长度一定是符合要求的最短长度
            // 如果取更短的片段，则一定会出现同一个字母出现在多个片段中的情况。由于每次取的片段都是符合要求的最短的片段，因此得到的片段数也是最多的。

            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> partitionLabels(String s) {
            int[] cnt = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cnt[c - 'a'] = Math.max(cnt[c - 'a'], i);
            }
            //System.out.println(Arrays.toString(cnt));
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); ) {
                int far = cnt[s.charAt(i) - 'a'];
                for (int j = i + 1; j <= far; j++) {
                    if (cnt[s.charAt(j) - 'a'] > far) {
                        far = Math.max(cnt[s.charAt(j) - 'a'], far);
                    }
                }
                res.add(far - i + 1);
                i = far + 1;
            }
            return res;
        }
    }
}
