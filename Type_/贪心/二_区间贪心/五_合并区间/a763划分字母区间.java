package Type_.贪心.二_区间贪心.五_合并区间;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/02/18
 * @Description:
 */
public class a763划分字母区间 {
    class S1 {
        class Solution {
            public List<Integer> partitionLabels(String s) {
                Map<Character, int[]> record = new HashMap<>();
                //记录每个字母的最远位置
                boolean[] seen = new boolean[26];
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (!record.containsKey(c)) {
                        record.put(c, new int[]{i, i});
                    } else {
                        int[] pos = record.get(c);
                        pos[1] = i;
                    }
                }
                for (Map.Entry<Character, int[]> e : record.entrySet()) {
                    System.out.println(e.getKey() + ":" + Arrays.toString(e.getValue()));
                }

                List<List<Integer>> range = new ArrayList<>();
                for (char c : s.toCharArray()) {
                    //可以合并
                    int start = record.get(c)[0], end = record.get(c)[1];
                    if (!range.isEmpty() && range.getLast().get(1) >= start) {
                        int last = Math.max(end, range.getLast().get(1));
                        int first = Math.min(start, range.getLast().get(0));
                        range.removeLast();
                        range.add(List.of(first, last));
                    } else
                        range.add(List.of(start, end));
                }
                List<Integer> res = new ArrayList<>(range.size());
                for (List<Integer> list : range) {
                    res.add(list.get(1) - list.get(0) + 1);
                }
                return res;
            }
        }
    }

    class S2 {
        class Solution {
            public List<Integer> partitionLabels(String s) {
                int[] cnt = new int[26];

                //记下索引最远位置
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    cnt[ch - 'a'] = Math.max(cnt[ch - 'a'], i);
                }

                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < s.length(); ) {
                    char ch = s.charAt(i);
                    int idx = ch - 'a';
                    int farthest = cnt[idx];

                    for (int j = i + 1; j <= farthest; j++) {
                        farthest = Math.max(farthest, cnt[s.charAt(j) - 'a']);
                    }
                    res.add(farthest - i + 1);
                    i = farthest + 1;
                }
                return res;
            }
        }
    }
}
