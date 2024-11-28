package Hot100.设计;

/**
 * @Author: ZJX
 * @Date: 2024/11/28
 * @Description:
 */
public interface PQ<T> {

    // 返回队列中的元素个数
    int size();

    // 向队列中插入一个元素
    void push(T t);

    // 返回队列中的最小元素（堆顶元素）
    T peek();

    // 删除并返回队列中的最小元素（堆顶元素）
    T pop();
}
