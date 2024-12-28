package 面试150;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/27
 * @Description:
 */
public class a30串联所有单词的子串 {
    /**
     * 朴素哈希表
     */
    class S1 {
        class Solution {
            public List<Integer> findSubstring(String s, String[] words) {
                char[] cs = s.toCharArray();
                //定长滑动窗口
                int w = words[0].length(), m = words.length;
                List<Integer> res = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                Map<String, Integer> record = new HashMap<>();
                for (String word : words) record.put(word, record.getOrDefault(word, 0) + 1);
                int lo = 0, hi = w * m;
                if (sb.length() == w * m && check(sb, record, w * m))
                    res.add(0);
                for (; hi < cs.length; hi++, lo++) {
                    sb.deleteCharAt(0);
                    sb.append(cs[hi]);
                    if (check(sb, new HashMap<>(record), w * m)) {
                        res.add(lo + 1);
                    }
                }
                return res;
            }

            private boolean check(StringBuilder sb, Map<String, Integer> record, int wordLen) {
                Map<String, Integer> cur = new HashMap<>();
                for (int i = 0; i < sb.length(); i += wordLen) {
                    String sub = sb.substring(i, i + wordLen);
                    cur.put(sub, cur.getOrDefault(sub, 0) + 1);
                }
                for (Map.Entry<String, Integer> e : record.entrySet()) {
                    if (!cur.containsKey(e.getKey()))
                        return false;
                    if (!cur.get(e.getKey()).equals(e.getValue()))
                        return false;
                }
                return true;
            }
        }
    }

    /**
     * 将起点根据 当前下标与单词长度的取余结果 进行分类
     */
    class S2 {
        class Solution {
            public List<Integer> findSubstring(String s, String[] words) {
                int n = s.length(), m = words.length, d = words[0].length(), l = m * d;
                //d为单词长度,总共需要d个滑动窗口的起点
                //统计
                Map<String, Integer> record = new HashMap<>();
                for (String w : words)
                    record.put(w, record.getOrDefault(w, 0) + 1);
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < d; i++) {
                    int left = i, right = i;
                    HashMap<String, Integer> curRecord = new HashMap<>();
                    //先放进 m 个单词到滑动窗口中
                    for (int j = 0; j < m; j++) {
                        //如果一组单词都没有办法放完,说明 s长度不够
                        if (right + d > n)
                            break;
                        String curWord = s.substring(right, right + d);
                        curRecord.put(curWord, curRecord.getOrDefault(curWord, 0) + 1);
                        right += d;
                    }
                    //刚放完m个单词,先判断一次
                    if (curRecord.equals(record))
                        res.add(left);
                    //开始移动,维护滑动窗口
                    while (right + d <= n) {
                        String leftWord = s.substring(left, left + d);
                        String rightWord = s.substring(right, right + d);

                        curRecord.put(rightWord, curRecord.getOrDefault(rightWord, 0) + 1);
                        curRecord.put(leftWord, curRecord.get(leftWord) - 1);
                        if (curRecord.get(leftWord) == 0)
                            curRecord.remove(leftWord);
                        left += d;
                        right += d;
                        //更新后判断
                        if (curRecord.equals(record))
                            res.add(left);
                    }
                }
                return res;
            }
        }
    }
}
