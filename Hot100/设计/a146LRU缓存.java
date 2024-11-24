package Hot100.设计;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/11/24
 * @Description:
 */


public class a146LRU缓存 {

    class Node {
        public int key, value;
        public Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    class DoubleList {
        //头部虚节点
        private final Node head;
        private final Node tail;
        //节点个数
        private int size;

        public DoubleList() {
            // 初始化双向链表的数据
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //增加元素,在链表尾部增加 - 时间0(1)
        public void addLast(Node x) {
            x.next = tail;
            x.prev = tail.prev;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        //删除元素,在链表头部进行删除,并且返回该节点 - 时间O(1)
        public Node removeFirst() {
            Node node = head.next;
            //没有元素可以删
            if (node == tail)
                return null;
            remove(node);
            return node;
        }

        // 删除链表中的 x 节点（x 一定存在）- 一般性的删除
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            x.next.prev = x.prev;
            x.prev.next = x.next;
            size--;
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return this.size;
        }
    }

    class LRUCache {
        // key -> Node(key, val)
        private final Map<Integer, Node> record;

        // Node(k1, v1) <-> Node(k2, v2)...
        private final DoubleList cache;
        // 最大容量
        private final int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            record = new HashMap<>();
            cache = new DoubleList();

        }

        // 将某个 key 提升为最近使用的
        private void makeRecently(int key) {
            Node x = record.get(key);
            // 先从链表中删除这个节点
            cache.remove(x);
            // 重新插到队尾
            cache.addLast(x);
        }

        //添加最近使用的元素
        private void addRecently(int key, int value) {
            Node x = new Node(key, value);
            // 链表尾部就是最近使用的元素
            cache.addLast(x);
            // 在 map 中添加 key 的映射
            record.put(key, x);
        }

        // 删除某一个 key
        private void deleteKey(int key) {
            Node x = record.get(key);
            // 从链表中删除
            cache.remove(x);
            // 从 map 中删除
            record.remove(key);
        }

        // 删除最久未使用的元素
        private void removeLeastRecently() {
            // 链表头部的第一个元素就是最久未使用的
            Node x = cache.removeFirst();
            // 从 map 中删除它的 key
            record.remove(x.key);
        }

        public int get(int key) {
            if (!record.containsKey(key)) {
                return -1;
            }
            // 将该数据提升为最近使用的
            makeRecently(key);
            return record.get(key).value;
        }

        public void put(int key, int value) {
            if (record.containsKey(key)) {
                // 删除旧的数据
                deleteKey(key);
                // 新插入的数据为最近使用的数据
                addRecently(key, value);
                return;
            }
            if (cache.size() == cap) {
                // 删除最久未使用的元素
                removeLeastRecently();
            }
            // 添加为最近使用的元素
            addRecently(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    /**
     * 直接用LinkedHashMap实现
     */
    /*class LRUCache {
        Map<Integer, Integer> cache = new LinkedHashMap<>();
        int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key))
                return -1;
            // 将 key 变为最近使用
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, value);
                // 将 key 变为最近使用
                return;
            }
            if (cache.size() >= cap) {
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }

    }*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
