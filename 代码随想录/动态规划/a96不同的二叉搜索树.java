package 代码随想录.动态规划;

/**
 * @Author: ZJX
 * @Date: 2024/10/28
 * @Description:
 */
public class a96不同的二叉搜索树 {
    class Solution {
        //元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
        //元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
        //元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
        public int numTrees(int n) {
            if (n <= 2)
                return n;
            //base case
            int[] f = new int[n + 1];
            //f[i] ： 1到i为节点组成的二叉搜索树的个数为f[i]。
            //也可以理解是i个不同元素节点组成的二叉搜索树的个数为f[i] ，都是一样的。
            f[0] = 1;
            f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    f[i] += f[j - 1] * f[i - j];
                }
            }
            return f[n];
        }
    }
}
