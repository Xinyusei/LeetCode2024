package Type_.数据结构.六_前缀树Trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/23
 * @Description:
 */
public class TrieMap<V> {
    //ASCII 码 个数
    private final static int R = 256;

    //当前存在 Map 中的键值对个数
    private int size = 0;

    //节点
    private static class TrieNode<V> {
        V val = null; // value
        TrieNode<V>[] children = new TrieNode[R]; //指向孩子节点的边
    }

    // Trie 树的根节点
    private TrieNode<V> root = null;


    public int size() {
        return this.size;
    }

    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        //从 node 开始 搜索 key
        for (int i = 0; i < key.length() && p != null; i++) {
            //向下搜索
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;

    }

    // 搜索 key 对应的值，不存在则返回 null
    private V get(String key) {
        // 从 root 开始搜索 key
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null)
            return null;

        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    private boolean containsKey(String key) {
        return get(key) != null;
    }

    // 判断是和否存在前缀为 prefix 的键
    private boolean hasKeyWithPrefix(String prefix) {
        // 只要能找到一个节点，就是存在前缀
        return getNode(root, prefix) != null;
    }

    // 在所有键中寻找 key 的最短前缀 - 找最短的树枝
    private String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        //从 root 开始向下搜索 key
        for (int i = 0; i < query.length(); i++) {
            if (p == null)
                //无法继续搜索了
                return "";

            if (p.val != null)
                return query.substring(0, i);

            //向下搜索
            p = p.children[query.charAt(i)];

        }

        if (p != null && p.val != null)
            // 如果 key 本身就是一个键
            return query;

        return "";

    }

    // 在所有键中寻找 query 的最长前缀 - 找最长的树枝
    private String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        int i = 0;
        //从 root 开始向下搜索 key

        for (; i < query.length(); i++) {
            if (p == null) {
                break;
            }
            //向下搜索
            p = p.children[query.charAt(i)];

        }
        if (p != null && p.val != null)
            // 如果 query 本身就是一个键
            return query;

        return query.substring(0, i);
    }

    // 搜索前缀为 prefix 的所有键
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        // 找到匹配 prefix 在 Trie 树中的那个节点
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        // DFS 遍历以 x 为根的这棵 Trie 树
        traverse(x, path, res);
        return res;
    }

    // 遍历以 node 节点为根的 Trie 树，找到所有键
    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null)
            return;

        if (node.val != null) {
            // 找到一个 key，添加到结果列表中
            res.add(new String(path));
        }
        // 回溯算法遍历框架
        for (int c = 0; c < R; c++) {
            // 做选择
            path.append(c);

            traverse(node.children[c], path, res);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 使用通配符来匹配多个键
    private List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    // 遍历函数，尝试在「以 node 为根的 Trie 树中」匹配 pattern[i..]
    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int startIndex, List<String> res) {
        if (node == null)
            // 树枝不存在，即字符 pattern[i-1] 匹配失败
            return;
        if (startIndex == pattern.length()) {
            // pattern 匹配完成
            if (node.val != null) {
                // 如果这个节点存储着 val，则找到一个匹配的键
                res.add(new String(path));
            }
            return;
        }


        char ch = path.charAt(startIndex);
        if (ch == '.') {
            for (int c = 0; c < R; c++) {
                // pattern[i] 是通配符，可以变化成任意字符
                // 多叉树（回溯算法）遍历框架
                path.append(c);
                traverse(node.children[c], path, pattern, startIndex + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            // pattern[i] 是普通字符 c
            path.append(ch);
            traverse(node.children[ch], path, pattern, startIndex + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    //判断是否存在键匹配模式串
    public boolean hasKeyWithPattern(String pattern) {
        // 一个偷懒的实现
        //return keysWithPattern(pattern).isEmpty();
        return traverse(root, new StringBuilder(), pattern, 0);
    }

    // 遍历函数，尝试在「以 node 为根的 Trie 树中」匹配 pattern[i..]
    private boolean traverse(TrieNode<V> node, StringBuilder path, String pattern, int startIndex) {
        if (node == null)
            // 树枝不存在，即字符 pattern[i-1] 匹配失败
            return false;
        if (startIndex == pattern.length()) {
            // 模式串走到头了，看看匹配到的是否是一个键
            return node.val != null;
        }

        char ch = path.charAt(startIndex);
        if (ch == '.') {
            for (int c = 0; c < R; c++) {
                // pattern[i] 可以变化成任意字符，尝试所有可能，只要遇到一个匹配成功就返回
                if (traverse(node.children[c], path, pattern, startIndex + 1))
                    return true;
            }
        } else {
            return traverse(node.children[ch], path, pattern, startIndex + 1);
        }
        //都没有匹配
        return false;
    }

    // 在 map 中添加或修改键值对
    public void put(String key, V val) {
        if (!containsKey(key)) {
            // 新增键值对
            size++;
        }
        // 需要一个额外的辅助函数，并接收其返回值
        root = put(root, key, val, 0);
    }
    // 在 map 中添加或修改键值对

    // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null)
            return new TrieNode<>();

        if (i == key.length()) {
            node.val = val;
            return node;
        }
        char ch = key.charAt(i);
        node.children[ch] = put(node.children[ch], key, val, i + 1);

        return node;
    }

    // 在 Map 中删除 key
    public void remove(String key) {
        if (!containsKey(key))
            return;
        // 递归修改数据结构要接收函数的返回值
        root = remove(root, key, 0);
        size--;
    }

    // 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null)
            return null;


        if (i == key.length()) {
            // 找到了 key 对应的 TrieNode，删除 val
            node.val = null;
        } else {
            char ch = key.charAt(i);
            // 递归去子树进行删除
            node.children[ch] = remove(node.children[ch], key, i + 1);
        }

        // 后序位置，递归路径上的节点可能需要被清理
        if (node.val != null)
            // 如果该 TireNode 存储着 val，不需要被清理
            return node;
        // 检查该 TrieNode 是否还有后缀
        for (int c = 0; c < R; c++) {
            if (node.children[c] != null)
                // 只要存在一个子节点（后缀树枝），就不需要被清理
                return node;
        }
        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }
}
