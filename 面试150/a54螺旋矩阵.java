package 面试150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/28
 * @Description:
 */
public class a54螺旋矩阵 {
    class S1 {
        class Solution {
            public List<Integer> spiralOrder(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;
                int top = 0, bottom = m - 1, left = 0, right = n - 1;
                List<Integer> res = new ArrayList<>();
                int all = m * n;
                while (res.size() < all) {
                    if (top <= bottom) {
                        for (int i = top, j = left; j <= right; j++) res.add(matrix[i][j]);
                        top++;
                    }
                    if (right >= left) {
                        for (int i = top, j = right; i <= bottom; i++) res.add(matrix[i][j]);
                        right--;
                    }
                    if (bottom >= top) {
                        for (int i = bottom, j = right; j >= left; j--) res.add(matrix[i][j]);
                        bottom--;
                    }
                    if (left <= right) {
                        for (int i = bottom, j = left; i >= top; i--) res.add(matrix[i][j]);
                        left++;
                    }
                }
                return res;
            }
        }
    }
}
