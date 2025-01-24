package Type_.数据结构.六_前缀树Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/24
 * @Description:
 */
public class a212单词搜索II {
    //todo
    class S1 {
        class Solution {
            private final static int R = 26;


            static class TrieNode {
                TrieNode[] children = new TrieNode[26];
                String word; // 直接存储单词，避免回溯拼接
            }

            private final static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            private final List<String> res = new ArrayList<>();

            public List<String> findWords(char[][] board, String[] words) {
                TrieNode root = buildTrie(words);
                int m = board.length, n = board[0].length;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        traverse(board, i, j, root);
                    }
                }

                return res;
            }

            private void traverse(char[][] board, int x, int y, TrieNode node) {
                int m = board.length, n = board[0].length;
                //越界
                if (node == null || x < 0 || x >= m || y < 0 || y >= n)
                    return;

                //代表已经遍历过 或者 不存在
                char c = board[x][y];
                if (c == '#' || node.children[c - 'a'] == null)
                    return;

                node = node.children[c - 'a'];
                // 找到单词时加入结果集，并去重（防止重复添加）
                if (node.word != null) {
                    res.add(node.word);
                    //去重
                    node.word = null;
                }

                //临时标记为已访问
                board[x][y] = '#';

                for (int[] d : dir) {
                    traverse(board, x + d[0], y + d[1], node);
                }
                // 恢复
                board[x][y] = c;
            }

            //构建 Trie 树
            public TrieNode buildTrie(String[] words) {
                TrieNode root = new TrieNode();
                for (String word : words) {
                    TrieNode p = root;
                    for (char c : word.toCharArray()) {
                        int idx = c - 'a';
                        if (p.children[idx] == null) {
                            p.children[idx] = new TrieNode();
                        }
                        p = p.children[idx];
                    }
                    p.word = word;
                }
                return root;
            }
        }
    }
}
