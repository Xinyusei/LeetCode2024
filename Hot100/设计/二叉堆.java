    package Hot100.设计;

    import java.util.Comparator;
    import java.util.NoSuchElementException;

    /**
     * @Author: ZJX
     * @Date: 2024/11/28
     * @Description:
     */
    public class 二叉堆 {
    }


    //1、不支持泛型，仅支持存储整数类型的元素。
    //2、不考虑扩容的问题，队列的容量在创建时固定，假设插入的元素数量不会超过这个容量。
    //3、底层仅实现一个小顶堆（即根节点是整个堆中的最小值），不支持自定义比较器。

    //用数组模拟二叉树，前提是这个二叉树必须是完全二叉树。

    class SimpleMinPQ implements PQ<Integer> {
        // 创建一个容量为 capacity 的优先级队列
        // 底层使用数组实现二叉堆
        private final int[] heap;

        //堆中元素的数量
        private int size;

        SimpleMinPQ(int capacity) {
            this.heap = new int[capacity];
            size = 0;
        }

        @Override
        public int size() {
            return this.size;
        }

        //父节点索引
        private int parent(int node) {
            return (node - 1) / 2;
        }

        //左子节点索引
        private int left(int node) {
            return node * 2 + 1;
        }

        //右子节点索引
        private int right(int node) {
            return node * 2 + 2;
        }

        // 交换数组的两个元素
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        //以小顶堆为例，向小顶堆中插入新元素遵循两个步骤：
        //1、先把新元素追加到二叉树底层的最右侧，保持完全二叉树的结构。此时该元素的父节点可能比它大，不满足小顶堆的性质。
        //2、为了恢复小顶堆的性质，需要将这个新元素不断上浮（swim），直到它的父节点比它小为止，或者到达根节点。此时整个二叉树就满足小顶堆的性质了。

        // 增，向堆中插入一个元素，时间复杂度 O(logN)
        @Override
        public void push(Integer x) {
            // 把新元素追加到最后
            heap[size] = x;
            // 然后上浮到正确位置
            swim(size);
            size++;
        }


        // 查，返回堆顶元素，时间复杂度 O(1)
        @Override
        public Integer peek() {
            return heap[0];
        }

        //以小顶堆为例，删除小顶堆的堆顶元素遵循两个步骤：
        //1、先把堆顶元素删除，把二叉树底层的最右侧元素摘除并移动到堆顶，保持完全二叉树的结构。此时堆顶元素可能比它的子节点大，不满足小顶堆的性质。
        //2、为了恢复小顶堆的性质，需要将这个新的堆顶元素不断下沉（sink），直到它比它的子节点小为止，或者到达叶子节点。此时整个二叉树就满足小顶堆的性质了。

        // 删，删除堆顶元素，时间复杂度 O(logN)
        @Override
        public Integer pop() {
            int res = heap[0];

            //把堆底元素放在堆顶
            heap[0] = heap[size - 1];
            size--;
            // 然后下沉到正确位置
            sink(0);

            return res;
        }

        // 上浮操作，时间复杂度是树高 O(logN)
        private void swim(int node) {
            while (node > 0 && heap[parent(node)] > heap[node]) {
                swap(node, parent(node));
                node = parent(node);
            }
        }

        // 下沉操作，时间复杂度是树高 O(logN)
        private void sink(int node) {
            while (left(node) < size || right(node) < size) {
                //比较自己和左右子节点，看谁最小
                int min = node;
                if (left(node) < size && heap[left(node)] < heap[min])
                    min = left(node);
                if (right(node) < size && heap[right(node)] < heap[min])
                    min = right(node);
                if (min == node)
                    break;
                swap(node, min);
                node = min;
            }
        }
    }

    class MyPriorityQueue<T> implements PQ<T> {
        private T[] heap;
        private int size;

        private final Comparator<? super T> comparator;

        public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
            heap = (T[]) new Object[capacity];
            size = 0;
            this.comparator = comparator;
        }

        @Override
        public int size() {
            return this.size;
        }

        //父节点索引
        private int parent(int node) {
            return (node - 1) / 2;
        }

        //左子节点索引
        private int left(int node) {
            return node * 2 + 1;
        }

        //右子节点索引
        private int right(int node) {
            return node * 2 + 2;
        }

        // 交换数组的两个元素
        private void swap(int i, int j) {
            T temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // 查，返回堆顶元素，时间复杂度 O(1)
        @Override
        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Priority queue underflow");
            }
            return heap[0];
        }

        // 增，向堆中插入一个元素，时间复杂度 O(logN)
        @Override
        public void push(T t) {
            // 扩容
            if (size == heap.length) {
                resize(2 * heap.length);
            }
            // 把新元素追加到最后
            heap[size] = t;
            // 然后上浮到正确位置
            swim(size);
            size++;


        }

        // 上浮操作，时间复杂度是树高 O(logN)
        private void swim(int node) {
            while (node > 0 && comparator.compare(heap[parent(node)], heap[node]) > 0) {
                swap(parent(node), node);
                node = parent(node);
            }
        }


        @Override
        public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Priority queue underflow");
            }
            T res = heap[0];
            // 把堆底元素放到堆顶
            swap(0, size - 1);
            // 避免对象游离
            heap[size - 1] = null;
            size--;
            // 然后下沉到正确位置
            sink(0);
            // 缩容
            if ((size > 0) && (size == heap.length / 4))
                resize(heap.length / 2);
            return res;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 下沉操作，时间复杂度是树高 O(logN)
        private void sink(int node) {
            while (left(node) < size || right(node) < size) {
                int min = node;
                if (left(node) < size && comparator.compare(heap[left(node)], heap[min]) < 0)
                    min = left(node);
                if (right(node) < size && comparator.compare(heap[right(node)], heap[min]) < 0)
                    min = right(node);
                if (min == node)
                    break;
                // 如果左右子节点中有比自己小的，就交换
                swap(node, min);
                node = min;
            }
        }

        // 调整堆的大小
        @SuppressWarnings("unchecked")
        private void resize(int capacity) {
            assert capacity > size;
            T[] temp = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(heap, 0, temp, 0, size);
            heap = temp;
        }


    }


    class test {


        public static void main(String[] args) {
            // PQ pq1 = new SimpleMinPQ(5);

            MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(3, Comparator.naturalOrder());
            pq.push(3);
            pq.push(2);
            pq.push(1);
            pq.push(5);
            pq.push(4);

            /*System.out.println(pq.pop()); // 1
            System.out.println(pq.pop()); // 2
            System.out.println(pq.pop()); // 3
            System.out.println(pq.pop()); // 4
            System.out.println(pq.pop()); // 5*/

            while (!pq.isEmpty()){
                System.out.println("pq.pop() = " + pq.pop());
            }
        }
    }
