package Type_.数据结构.六_前缀树Trie;

/**
 * @Author: ZJX
 * @Date: 2025/01/23
 * @Description:
 */
public class a208实现Trie前缀树 {
    class S1 {
        class Trie {
            private static final int R = 26;
            private final TrieNode root;

            private static class TrieNode {
                TrieNode[] children;
                boolean isEnd; //为 true，表示当前的路径指向的是一个值 为 false表示只是前缀的一部分

                public TrieNode() {
                    children = new TrieNode[R];
                    isEnd = false;
                }
            }

            public Trie() {
                this.root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new TrieNode();
                    }
                    node = node.children[idx];
                }
                //标记存在
                node.isEnd = true;
            }

            //them them
            public boolean search(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    if (node.children[idx] == null)
                        return false;
                    node = node.children[idx];
                }
                return node.isEnd;
            }

            //thema them
            public boolean startsWith(String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    int idx = prefix.charAt(i) - 'a';
                    if (node.children[idx] == null)
                        return false;
                    node = node.children[idx];
                }
                return true;
            }
        }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
    }
}
