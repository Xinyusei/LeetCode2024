package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2025/01/11
 * @Description:
 */
public class a427建立四叉树 {
    class S1 {
        // Definition for a QuadTree node.
        class Node {
            public boolean val;
            public boolean isLeaf;
            public Node topLeft;
            public Node topRight;
            public Node bottomLeft;
            public Node bottomRight;


            public Node() {
                this.val = false;
                this.isLeaf = false;
                this.topLeft = null;
                this.topRight = null;
                this.bottomLeft = null;
                this.bottomRight = null;
            }

            public Node(boolean val, boolean isLeaf) {
                this.val = val;
                this.isLeaf = isLeaf;
                this.topLeft = null;
                this.topRight = null;
                this.bottomLeft = null;
                this.bottomRight = null;
            }

            public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
                this.val = val;
                this.isLeaf = isLeaf;
                this.topLeft = topLeft;
                this.topRight = topRight;
                this.bottomLeft = bottomLeft;
                this.bottomRight = bottomRight;
            }
        }

        class Solution {
            int[][] g;
            int n;

            public Node construct(int[][] grid) {
                this.g = grid;
                this.n = g.length;

                return build(0, n - 1, n - 1, 0);
            }

            public Node build(int top, int right, int bottom, int left) {
                if (allSame(top, right, bottom, left))
                    return new Node(g[top][left] == 1, true);

                int mid1 = (top + bottom) >> 1, mid2 = (left + right) >> 1;
                Node topLeft = build(top, mid2, mid1, left);
                Node topRight = build(top, right, mid1, mid2 + 1);
                Node bottomLeft = build(mid1 + 1, mid2, bottom, left);
                Node bottomRight = build(mid1 + 1, right, bottom, mid2 + 1);

                return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

            }

            private boolean allSame(int top, int right, int bottom, int left) {
                for (int i = top; i <= bottom; i++) {
                    for (int j = left; j <= right; j++) {
                        if (g[i][j] != g[top][left])
                            return false;
                    }
                }
                return true;
            }
        }
    }
}
