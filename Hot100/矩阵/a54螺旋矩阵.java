package Hot100.矩阵;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a54螺旋矩阵 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int top = 0, bottom = m - 1, left = 0, right = n - 1;
            List<Integer> res = new LinkedList<>();
            // res.size() == m * n 则遍历完整个数组
            while (res.size() < m * n) {
                if (top <= bottom) {
                    //在顶部从左到右遍历
                    for (int col = left; col <= right; col++) res.add(matrix[top][col]);
                    //上边界下移
                    top++;
                }
                //在右侧从上到下遍历
                if (left <= right) {
                    for (int row = top; row <= bottom; row++) res.add(matrix[row][right]);
                    //右边界左移
                    right--;
                }
                if (top <= bottom) {
                    // 在底部从右向左遍历
                    for (int col = right; col >= left; col--) res.add(matrix[bottom][col]);
                    // 下边界上移
                    bottom--;
                }
                if (left <= right) {
                    // 在左侧从下向上遍历
                    for (int row = bottom; row >= top; row--) res.add(matrix[row][left]);
                    // 左边界右移
                    left++;
                }
            }
            return res;
        }
    }
}
