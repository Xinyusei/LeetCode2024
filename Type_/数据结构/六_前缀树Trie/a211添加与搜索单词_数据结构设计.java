package Type_.数据结构.六_前缀树Trie;

/**
 * @Author: ZJX
 * @Date: 2025/01/24
 * @Description:
 */
public class a211添加与搜索单词_数据结构设计 {
    class S1 {
        class WordDictionary {
            private final static int R = 26;

            private static class TrieNode {
                private boolean isEnd;
                private final TrieNode[] children;

                public TrieNode() {
                    isEnd = false;
                    this.children = new TrieNode[R];
                }
            }

            private final TrieNode root;

            public WordDictionary() {
                root = new TrieNode();
            }

            public void addWord(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    if (p.children[idx] == null)
                        p.children[idx] = new TrieNode();

                    p = p.children[idx];
                }
                p.isEnd = true;
            }

            //the th
            public boolean search(String word) {
                return traverse(word, 0, root);
            }

            private boolean traverse(String word, int index, TrieNode node) {
                if (node == null)
                    return false;
                if (index == word.length()){
                    return node.isEnd;
                }
                char ch = word.charAt(index);
                //如果是通配符
                if (ch == '.') {
                    for (int c = 0; c < R; c++) {
                        if (traverse(word, index + 1, node.children[c]))
                            return true;
                    }
                }
                //非通配符
                else {
                    return traverse(word, index + 1, node.children[ch - 'a']);
                }
                //没有找到
                return false;
            }

        }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
    }
}
