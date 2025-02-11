package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2024/12/28
 * @Description:
 */
public class a48旋转图像 {
    //todo 
    /**
     * 找规律 - 必须掌握
     */
    class S1 {
        class Solution {
            public void rotate(int[][] matrix) {
                int n = matrix.length;
                //i -> j
                //j -> n - 1 - i

                //( i ,j ) -> (j, n - 1 - i)
                //(j,n - 1 - i) -> (n - 1 - i, n - 1 - j)
                //(n - 1 - i, n - 1 - j) -> (n - 1 - j, i)
                //(n - 1 - j, i) -> (i, j)
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < (n + 1) / 2; j++) {
                        int temp = matrix[i][j]; //1
                        //以下是逆时针旋转
                        /*matrix[i][j] = matrix[j][n - 1 - i]; //
                        matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                        matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                        matrix[n - 1 - j][i] = temp;*/
                        //以下是顺时针旋转
                        matrix[i][j] = matrix[n - 1 - j][i];
                        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                        matrix[j][n - 1 - i] = temp;
                    }
                }
                //1 2 3
                //4 5 6
                //7 8 9
            }
        }
    }


    /**
     * 旋转的经典思路 - 翻转全部 + 翻转部分
     */
    class S2_1 {
        class Solution {
            public void rotate(int[][] matrix) {
                //先按 对角线翻转 再每行翻转

                int n = matrix.length;
                //1. 按对角线翻转
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
                //1 4 7
                //2 5 8
                //3 6 9

                //2.每一行再翻转
                for (int[] row : matrix) {
                    reverse(row, 0, row.length - 1);
                }
            }

            public void reverse(int[] row, int lo, int hi) {
                while (lo < hi) {
                    int temp = row[lo];
                    row[lo] = row[hi];
                    row[hi] = temp;
                    lo++;
                    hi--;
                }
            }
        }
    }

    /**
     *  旋转方式2 -> 翻转部分 +翻转全部
     */
    class S2_2 {
        class Solution {
            public void rotate(int[][] matrix) {
                //1. 每行翻转
                for (int[] row : matrix) {
                    reverse(row, 0, row.length - 1);
                }

                //3 2 1
                //6 5 4
                //9 8 7

                //2. 按主对角线翻转
                int n = matrix.length;
                for (int i = 0; i < n; i++) {
                    for (int j = n - i - 1; j >= 0; j--) {
                        int temp = matrix[i][j];
                        //0,0 0,1 1,0
                        //2,2 1,2 2,1
                        matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                        matrix[n - 1 - j][n - 1 - i] = temp;
                    }
                }
            }

            public void reverse(int[] row, int lo, int hi) {
                while (lo < hi) {
                    int temp = row[lo];
                    row[lo] = row[hi];
                    row[hi] = temp;
                    lo++;
                    hi--;
                }
            }
        }
    }
}



