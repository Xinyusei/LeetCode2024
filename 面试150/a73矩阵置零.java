package 面试150;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/29
 * @Description:
 */
public class a73矩阵置零 {

    /**
     * 将是否需要置0的信息直接映射在原矩阵中
     */
    class S2 {
        class Solution {
            public void setZeroes(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;
                boolean r0 = false, c0 = false;

                //先判断第 0 行 是否有0
                for (int r : matrix[0]) {
                    if (r == 0) {
                        r0 = true;
                        break;
                    }
                }
                //先判断第 0 列 是否有0
                for (int[] c : matrix) {
                    if (c[0] == 0) {
                        c0 = true;
                        break;
                    }
                }
                //遍历矩阵,将 每一个 0 的信息 映射到 矩阵的 第 0 行和 第 0 列
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 0) {
                            matrix[0][j] = matrix[i][0] = 0;
                        }
                    }
                }

                //再次遍历矩阵,根据  矩阵的 第 0 行和 第 0 列 所做的标记, 进行清理

                //从 第 1 行和 第 1 列 开始
                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                            matrix[i][j] = 0;
                        }
                    }
                }

                //判断第 0 行是否需要置 0
                if (r0) {
                    Arrays.fill(matrix[0], 0);
                }
                //判断第 0 列是否需要置 0

                if (c0) {
                    for (int i = 0; i < m; i++)
                        matrix[i][0] = 0;
                }
            }
        }
    }

    /**
     * 两个哈希表来存储 ，空间复杂度O(m + n)
     */
    class S1 {
        class Solution {
            public void setZeroes(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;
                Set<Integer> row = new HashSet<>(), col = new HashSet<>();

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 0) {
                            row.add(i);
                            col.add(j);
                        }
                    }
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (row.contains(i) || col.contains(j))
                            matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
