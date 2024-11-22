package Hot100.矩阵;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a885螺旋矩阵III {
    class Solution {
        int[][] f;
        int rows, cols, t = 1;

        //忽略是否在界外，直接转圈，那么就相当于在遍历一个大正方形，额外实现一个check方法，检查如果在界内就记录即可。
        //本题横竖需要走的格数遵从这样的规律1,1,2,2,3,3,4,4,...，因此可以使用两个变量row, col来记录横竖需要走的距离，每次走完一条直线就自增1，简化写法。
        void check(int r, int c) {
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (t == rows * cols)
                    return;
                f[t][0] = r;
                f[t][1] = c;
                t++;
            }
        }

        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            this.rows = rows;
            this.cols = cols;
            this.f = new int[rows * cols][2];
            //四个方向
            int row = 1, col = 1;
            f[0][0] = rStart;
            f[0][1] = cStart;
            if (rows * cols == 1)
                return f;
            while (t < rows * cols) {
                //东
                for (int i = 1; i <= row; i++) check(rStart, ++cStart);
                row++;
                //南
                for (int j = 1; j <= col; j++) check(++rStart, cStart);
                col++;
                //西
                for (int i = 1; i <= row; i++) check(rStart, --cStart);
                row++;
                //北
                for (int j = 1; j <= col; j++) check(--rStart, cStart);
                col++;
            }
            return f;
        }
    }
}
