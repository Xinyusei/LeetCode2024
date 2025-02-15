package Type_.链表.综合应用;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/02/15
 * @Description:
 */
public class a146LRU缓存 {
    //todo 
    class S1 {
        class LRUCache {
            private static class Node {
                int key, value;
                Node prev, next;

                Node(int k, int v) {
                    key = k;
                    value = v;
                }
            }

            private final int capacity;
            private final Node dummy;
            private final Map<Integer, Node> keyToNode;


            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.dummy = new Node(-1, -1);
                dummy.prev = dummy;
                dummy.next = dummy;
                this.keyToNode = new HashMap<>();
            }

            //删除node
            private void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            //把node添加到末尾
            private void pushLast(Node node) {
                node.prev = dummy.prev;
                node.next = dummy.prev.next;
                dummy.prev.next = node;
                dummy.prev = node;
            }


            private void pushFront(Node node) {
                node.next = dummy.next;
                node.prev = dummy;
                dummy.next.prev = node;
                dummy.next = node;
            }

            //如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
            public int get(int key) {
                Node node = getNode(key);
                return node != null ? node.value : -1;
            }

            //获取 key 对应的节点，同时把该节点移到链表头部
            private Node getNode(int key) {
                if (!keyToNode.containsKey(key)) //没有
                    return null;

                Node node = keyToNode.get(key);
                remove(node);
                pushFront(node);
                return node;
            }

            public void put(int key, int value) {
                Node node = getNode(key);
                if (node != null) {
                    node.value = value;
                    return;
                }

                node = new Node(key, value);
                keyToNode.put(key, node);
                pushFront(node);
                if (keyToNode.size() > capacity) {
                    Node backNode = dummy.prev;
                    keyToNode.remove(backNode.key);
                    remove(backNode);
                }
            }
        }
    }

    class S2 {
        class LRUCache {
            private static class Node {
                int key, value;
                Node prev, next;

                Node(int k, int v) {
                    key = k;
                    value = v;
                }
            }

            private final int capacity;
            private final Node dummy;
            private final Map<Integer, Node> keyToNode;


            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.dummy = new Node(-1, -1);
                dummy.prev = dummy;
                dummy.next = dummy;
                this.keyToNode = new HashMap<>();
            }

            //删除node
            private void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            //把node添加到末尾
            private void pushLast(Node node) {
                node.prev = dummy.prev;
                node.next = dummy.prev.next;
                dummy.prev.next = node;
                dummy.prev = node;
            }


            //如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
            public int get(int key) {
                Node node = getNode(key);
                return node != null ? node.value : -1;
            }

            //获取 key 对应的节点，同时把该节点移到链表头部
            private Node getNode(int key) {
                if (!keyToNode.containsKey(key)) //没有
                    return null;

                Node node = keyToNode.get(key);
                remove(node);
                pushLast(node);
                return node;
            }

            public void put(int key, int value) {
                Node node = getNode(key);
                if (node != null) {
                    node.value = value;
                    return;
                }

                node = new Node(key, value);
                keyToNode.put(key, node);
                pushLast(node);
                if (keyToNode.size() > capacity) {
                    Node frontNode = dummy.next;
                    keyToNode.remove(frontNode.key);
                    remove(frontNode);
                }
            }
        }
    }
}
