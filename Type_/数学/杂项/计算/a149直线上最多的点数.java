package Type_.数学.杂项.计算;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/01/20
 * @Description:
 */
public class a149直线上最多的点数 {
    /**
     * 枚举直线 + 哈希表统计
     */
    class S2 {
        class Solution {
            public int maxPoints(int[][] points) {
                int n = points.length, res = 1;
                for (int i = 0; i < n; i++) {
                    int[] x = points[i];
                    int x1 = x[0], y1 = x[1];
                    Map<String, Integer> map = new HashMap<>();
                    // 由当前点 i 发出的直线所经过的最多点数量
                    //表示 <本斜率：本斜率数量>的映射
                    int cnt = 0;
                    for (int j = i + 1; j < n; j++) {
                        int[] y = points[j];
                        int x2 = y[0], y2 = y[1];
                        int a = x2 - x1, b = y2 - y1;
                        int k = gcd(a, b);

                        String key = (a / k) + "_" + (b / k);
                        map.put(key, map.getOrDefault(key, 0) + 1);
                        cnt = Math.max(cnt, map.get(key));
                    }
                    res = Math.max(res, cnt);
                }
                return res;
            }

            private int gcd(int a, int b) {
                return b == 0 ? a : gcd(b, a % b);
            }
        }
    }

    /**
     * 朴素做法 ： 枚举直线 + 枚举统计 ， 优化：将存在精度问题的[除法判定]改为[乘法判定]
     */
    class S1 {
        class Solution {
            public int maxPoints(int[][] points) {
                int n = points.length, res = 1;
                for (int i = 0; i < n; i++) {
                    //y1 - x1 / y0 - x0 = k1 - y1 / k0 - y0
                    int[] x = points[i];
                    for (int j = i + 1; j < n; j++) {
                        int[] y = points[j];
                        int cnt = 2;
                        // 枚举点对 (i,j) 并统计有多少点在该线上, 起始 cnt = 2 代表只有 i 和 j 两个点在此线上
                        for (int k = j + 1; k < n; k++) {
                            int[] p = points[k];
                            int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                            int s2 = (y[0] - x[0]) * (p[1] - y[1]);
                            if (s1 == s2)
                                cnt++;
                        }
                        res = Math.max(res, cnt);
                    }
                }
                return res;
            }
        }
    }


}
