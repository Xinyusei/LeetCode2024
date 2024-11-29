package Type_.数据结构.栈以及栈的应用.括号问题;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a1541平衡括号字符串的最少插入次数 {
    class Solution {
        public int minInsertions(String s) {
            // res 记录插入次数
            int res = 0;
            // need 变量记录右括号的需求量
            int need = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    // 对右括号的需求 + 2
                    need += 2;
                    //另外，当遇到左括号时，若对右括号的需求量为奇数，需要插入 1 个右括号。
                    // 因为一个左括号需要两个右括号嘛，右括号的需求必须是偶数，这一点也是本题的难点。
                    if ((need & 1) == 1) {
                        //插入一个右括号
                        res++;
                        //右括号需求--
                        need--;
                    }
                } else {
                    need--;
                    //什么时候需要插入呢
                    //此时没有需要匹配的左括号,但是多出了一个右括号,右括号需要额外的左括号来匹配,res++代表插入一个左括号
                    // 此时need变为1，对右括号的需求减为1. 因为插入了一个左括号,但是一个左括号需要连续两个右括号匹配
                    if (need == -1) {
                        res++;
                        need = 1;
                    }

                    //
                }
            }
            return need + res;
        }
    }
}
