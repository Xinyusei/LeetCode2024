package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/01/07
 * @Description:
 */
public class a127单词接龙 {
    /**
     * BFS + 哈希表
     */
    class S1 {
        class Solution {
            public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                List<String> queue = new ArrayList<>();
                Map<String, Integer> record = new HashMap<>();

                record.put(beginWord, 0);
                queue.add(beginWord);

                while (!queue.isEmpty()) {
                    String curr = queue.removeFirst();
                    Integer cnt = record.get(curr);
                    if (curr.equals(endWord))
                        return cnt + 1;
                    for (String s : wordList) {
                        if (s.equals(curr) || record.containsKey(s))
                            continue;

                        if (valid(s, curr)) {
                            queue.add(s);
                            record.put(s, cnt + 1);
                        }
                    }
                }
                return 0;
            }

            private boolean valid(String s, String curr) {
                int cnt = 0;
                for (int i = 0; i < s.length() && cnt <= 1; i++) {
                    if (s.charAt(i) != curr.charAt(i))
                        cnt++;
                }
                return cnt <= 1;
            }
        }
    }

    /**
     * BFS + 哈希表 + 哈希集合（优化判断字符串的是否符合只差一个字母的过程）
     */
    class S2 {
        class Solution {
            public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                List<String> queue = new ArrayList<>();
                Map<String, Integer> record = new HashMap<>();
                Set<String> wordSet = new HashSet<>(wordList);

                record.put(beginWord, 0);
                queue.add(beginWord);

                while (!queue.isEmpty()) {
                    String curr = queue.removeFirst();
                    Integer cnt = record.get(curr);
                    if(curr.equals(endWord))
                        return cnt + 1;
                    char[] copy = curr.toCharArray(); //复制一份
                    //逐一替换单词中的字符
                    for (int i = 0; i < copy.length; i++) {
                        char oldChar = copy[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            copy[i] = c;
                            String nxtWord = new String(copy);
                            if (wordSet.contains(nxtWord) && !record.containsKey(nxtWord)) {
                                queue.add(nxtWord);
                                record.put(nxtWord, cnt + 1);
                            }
                        }
                        copy[i] = oldChar;
                    }
                }
                return 0;
            }

        }
    }

    /**
     * 双向BFS todo
     */
    class S3{

    }
}
