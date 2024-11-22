package Hot100.矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a73矩阵置零 {
    class Solution1 {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] rowRecord = new boolean[m], colRecord = new boolean[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        rowRecord[i] = colRecord[j] = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rowRecord[i] || colRecord[j])
                        matrix[i][j] = 0;
                }
            }
        }
    }

    class Solution2 {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean zeroRow = false, zeroCol = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    zeroCol = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    zeroRow = true;
                    break;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0)
                        matrix[i][j] = 0;
                }
            }
            if (zeroRow) {
                for (int j = 0; j < n; j++) matrix[0][j] = 0;
            }
            if (zeroCol) {
                for (int i = 0; i < m; i++) matrix[i][0] = 0;
            }
        }
    }
}
