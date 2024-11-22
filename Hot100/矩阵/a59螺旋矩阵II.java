package Hot100.矩阵;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a59螺旋矩阵II {
    class Solution {
        public int[][] generateMatrix(int n) {
            int top = 0, bottom = n - 1, left = 0, right = n - 1;
            int[][] f = new int[n][n];
            int cnt = 1;
            while (cnt <= n * n) {
                if (top <= bottom) {
                    //在顶部从左到右遍历
                    for (int col = left; col <= right; col++, cnt++) f[top][col] = cnt;
                    //上边界下移
                    top++;
                }
                //在右侧从上到下遍历
                if (left <= right) {
                    for (int row = top; row <= bottom; row++, cnt++) f[row][right] = cnt;
                    //右边界左移
                    right--;
                }
                if (top <= bottom) {
                    // 在底部从右向左遍历
                    for (int col = right; col >= left; col--, cnt++) f[bottom][col] = cnt;
                    // 下边界上移
                    bottom--;
                }
                if (left <= right) {
                    // 在左侧从下向上遍历
                    for (int row = bottom; row >= top; row--, cnt++) f[row][left] = cnt;
                    // 左边界右移
                    left++;
                }
            }
            return f;
        }
    }
}
