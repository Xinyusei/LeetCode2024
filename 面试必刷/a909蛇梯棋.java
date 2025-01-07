package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/01/07
 * @Description:
 */
public class a909蛇梯棋 {
    class S1 {
        class Solution {
            public int snakesAndLadders(int[][] board) {
                int n = board.length;
                int target = n * n;
                // BFS initialization
                List<Integer> queue = new ArrayList<>();
                Map<Integer, Integer> record = new HashMap<>();
                queue.addLast(1);
                record.put(1, 0);

                while (!queue.isEmpty()) {
                    int curr = queue.removeFirst();
                    int currDist = record.get(curr);
                    if (curr == target) {
                        return currDist;
                    }
                    for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                        int[] pos = getPosition(next, n);
                        int row = pos[0];
                        int col = pos[1];
                        int destination = board[row][col] != -1 ? board[row][col] : next;

                        if (!record.containsKey(destination)) {
                            record.put(destination, currDist + 1);
                            queue.addLast(destination);
                        }
                    }
                }
                return -1;
            }

            private int[] getPosition(int index, int n) {
                int row = (index - 1) / n;
                int col = (index - 1) % n;
                if ((row & 1) == 0) {
                    return new int[]{n - 1 - row, col};
                } else {
                    return new int[]{n - 1 - row, n - 1 - col};
                }
            }
        }
    }
}
