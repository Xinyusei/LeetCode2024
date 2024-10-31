package 代码随想录.KamaCoder.完全背包;

import java.util.Scanner;

/**
 * @Author: ZJX
 * @Date: 2024/10/31
 * @Description:
 */
public class w57爬楼梯进阶 {

    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            //f[i] 表示有 f[i]中方法爬到第 i 层楼梯
            int[] f = new int[n + 1];
            f[0] = 1;
            //f[i] 由 f[i - x(x属于[1,m]决定)]
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i >= j)
                        f[i] += f[i - j];
                }
            }
            System.out.println(f[n]);
        }
    }
}
