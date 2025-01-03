package 面试必刷;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/01/02
 * @Description:
 */
public class a146LRU缓存 {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        final Node dummy;
        int size;

        //init
        public DoubleList() {
            dummy = new Node(0, 0);

            dummy.next = dummy;
            dummy.prev = dummy;

            size = 0;
        }

        // 在链表末尾增加元素 node
        public void addLast(Node node) {
            Node last = dummy.prev;
            doAddBetween(node, last, dummy);
        }

        // 在 prev 节点之后 next 结点之前 添加 node节点。
        public void doAddBetween(Node node, Node prev, Node next) {
            node.next = next;
            node.prev = prev;
            prev.next = node;
            next.prev = node;

            size++;
        }

        // 在链表头部删除元素
        public Node removeFirst() {
            Node node = dummy.next;
            if (node == dummy)
                return null;
            doRemove(node);
            return node;
        }

        // 删除链表中的 node 节点（node 一定存在）- 一般性的删除
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        void doRemove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }

    class LRUCache {
        // 建立 key -> Node 的映射关系
        final HashMap<Integer, Node> record;

        // 双向链表
        final DoubleList cache;

        //最大容量
        final int cap;

        //init
        public LRUCache(int capacity) {
            this.cap = capacity;
            record = new HashMap<>();
            cache = new DoubleList();
        }

        // 将某个 key 提升为最近使用的
        // 1. 找到节点
        // 2. 删除节点
        // 3. 将节点添加到链表末尾
        public void makeRecently(int key) {
            Node node = record.get(key);
            cache.doRemove(node);
            cache.addLast(node);
        }

        // 删除最久未使用的元素
        public void removeLeastRecently() {
            Node first = cache.removeFirst();
            record.remove(first.key);
        }


        //如果 关键字key在缓存中,返回 value
        //否则 返回 -1
        public int get(int key) {
            if (!record.containsKey(key)) {
                return -1;
            }
            Node node = record.get(key);
            //让 key对应的node 变为最近使用的。
            makeRecently(key);
            return node.value;
        }

        private void deleteKey(int key) {
            cache.doRemove(record.get(key));
            record.remove(key);
        }

        private void addRecently(int key, int value) {
            Node node = new Node(key, value);
            cache.addLast(node);
            record.put(key, node);
        }

        // 关键字存在, 替换
        // 关键字不存在，插入 - 如果容量超过cap则删除 最久未使用(链表最前面的节点)
        public void put(int key, int value) {
            //1. 关键字存在, 替换
            if (record.containsKey(key)) {
                deleteKey(key);
                addRecently(key, value);
                return;
            }
            //2. 不存在，插入 
            //2.1 容量已满,删除最近最少使用的。
            if (cache.size == cap) {
                removeLeastRecently();
            }
            // 插入
            addRecently(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
