package 代码随想录.贪心;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/18
 * @Description:
 */
public class a455分发饼干 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            //g:最小满足值
            //s:饼干大小
            //只要饼干大小 大于 最小满足的值，res++
            Arrays.sort(g);
            Arrays.sort(s);
            int res = 0;
            int j = 0;
            for (int i = 0; i < g.length; i++) {
                int v = g[i];
                while (j < s.length && s[j] < v) {
                    j++;
                }
                if (j < s.length && s[j] >= v){
                    res++;
                    j++;
                }
            }
            return res;
        }
    }
}
