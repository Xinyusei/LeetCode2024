package Hot100.设计;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2024/11/27
 * @Description:
 */
public class a208实现Trie前缀树 {
    class Trie {
        class TrieNode {
            private final TrieNode[] children;
            private boolean isEnd;
            private static final int R = 26;

            public TrieNode() {
                children = new TrieNode[R];
                isEnd = false;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();

                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode trieNode = searchPrefix(word);
            return trieNode != null && trieNode.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int idx = c - 'a';
                if (node.children[idx] == null)
                    return null;
                node = node.children[idx];
            }
            return node;
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
