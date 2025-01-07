package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/01/07
 * @Description:
 */
public class a433最小基因变化 {

    /**
     * BFS - 最短路 - 提前建好图
     */
    class S1_1 {
        class Solution {
            public int minMutation(String startGene, String endGene, String[] bank) {
                Map<String, List<String>> g = new HashMap<>();

                for (int i = 0; i < bank.length; i++) {
                    String a = bank[i];
                    g.putIfAbsent(a, new ArrayList<>());
                    for (int j = i + 1; j < bank.length; j++) {
                        String b = bank[j];
                        g.putIfAbsent(b, new ArrayList<>());
                        if (check(a, b)) {
                            g.get(a).add(b);
                            g.get(b).add(a);
                        }
                    }
                }
                if (!g.containsKey(startGene)) {
                    g.put(startGene, new ArrayList<>());
                    for (String b : bank) {
                        if (check(startGene, b)) {
                            g.get(b).add(startGene);
                            g.get(startGene).add(b);
                        }
                    }
                }
                //System.out.println("g = " + g);
                if (!g.containsKey(endGene))
                    return -1;

                return bfs(g, startGene, endGene);
            }

            private int bfs(Map<String, List<String>> g, String startGene, String endGene) {
                //bfs

                //记录 start 到 当前 s 的最小变化次数
                Map<String, Integer> record = new HashMap<>();

                List<String> queue = new ArrayList<>();
                queue.add(startGene);
                record.put(startGene, 0);

                while (!queue.isEmpty()) {
                    String cur = queue.removeFirst();
                    for (String nxt : g.get(cur)) {
                        if (record.containsKey(nxt))
                            continue;
                        record.put(nxt, record.getOrDefault(cur, 0) + 1);
                        if (nxt.equals(endGene))
                            return record.get(endGene);
                        queue.add(nxt);
                    }
                }
                return -1;
            }


            private boolean check(String a, String b) {
                int cnt = 0;
                for (int i = 0; i < a.length() && cnt <= 1; i++) {
                    if (a.charAt(i) != b.charAt(i))
                        cnt++;
                }
                return cnt <= 1;
            }
        }
    }

    /**
     * BFS - 遍历的时候一步步建图
     */
    class S1_2 {
        class Solution {
            public int minMutation(String startGene, String endGene, String[] bank) {
                return bfs(startGene, endGene, bank);
            }
            private int bfs(String startGene, String endGene, String[] bank) {
                //bfs
                //记录 start 到 当前 s 的变化次数
                Map<String, Integer> record = new HashMap<>();
                List<String> queue = new ArrayList<>();

                queue.add(startGene);
                record.put(startGene, 0);

                while (!queue.isEmpty()) {
                    String cur = queue.removeFirst();
                    if(cur.equals(endGene))
                        return record.get(endGene);
                    for (String nxt : bank) {
                        if (cur.equals(nxt) || record.containsKey(nxt))
                            continue;
                        if (check(cur, nxt)) {
                            queue.add(nxt);
                            record.put(nxt, record.getOrDefault(cur, 0) + 1);
                        }
                    }
                }
                return -1;
            }


            private boolean check(String a, String b) {
                int cnt = 0;
                for (int i = 0; i < a.length() && cnt <= 1; i++) {
                    if (a.charAt(i) != b.charAt(i))
                        cnt++;
                }
                return cnt <= 1;
            }
        }
    }

    class S2 {
        class Solution {
            public int minMutation(String startGene, String endGene, String[] bank) {
                Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
                if (!geneBank.contains(endGene)) {
                    return -1;
                }

                char[] genes = {'A', 'C', 'G', 'T'};
                Queue<String> queue = new LinkedList<>();
                queue.offer(startGene);

                Map<String, Integer> visited = new HashMap<>();
                visited.put(startGene, 0);

                while (!queue.isEmpty()) {
                    String current = queue.poll();
                    int steps = visited.get(current);

                    if (current.equals(endGene)) {
                        return steps;
                    }

                    char[] currentArray = current.toCharArray();
                    for (int i = 0; i < currentArray.length; i++) {
                        char originalChar = currentArray[i];
                        for (char gene : genes) {
                            if (gene == originalChar) {
                                continue;
                            }
                            currentArray[i] = gene;
                            String nextGene = new String(currentArray);
                            if (geneBank.contains(nextGene) && !visited.containsKey(nextGene)) {
                                visited.put(nextGene, steps + 1);
                                queue.offer(nextGene);
                            }
                        }
                        currentArray[i] = originalChar;
                    }
                }
                return -1;
            }

        }
    }
}
