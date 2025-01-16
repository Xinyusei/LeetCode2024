package Type_.数学.杂项.计算;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a66加一 {

    class S2 {
        class Solution {
            public int[] plusOne(int[] digits) {
                for (int i = digits.length - 1; i >= 0; i--) {
                    digits[i] = (digits[i] + 1) % 10;
                    //0,0
                    if (digits[i] != 0)
                        return digits;
                }
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
        }
    }

    class S1 {
        class Solution {
            public int[] plusOne(int[] digits) {
                List<Integer> ls = new ArrayList<>();
                int carry = 1;
                for (int i = digits.length - 1; i >= 0 || carry != 0; i--) {
                    int v = carry;
                    v += i >= 0 ? digits[i] : 0;
                    ls.add(v % 10);
                    carry = v / 10;
                }
                int[] res = new int[ls.size()];
                for (int i = 0; i < ls.size(); i++) {
                    res[i] = ls.get(ls.size() - i - 1);
                }
                return res;
            }
        }
    }
}
