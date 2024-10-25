package lcRating.gt1400le1600;

/**
 * @Author: ZJX
 * @Date: 2024/10/25
 * @Description:
 */
public class a2437有效时间的数目 {


    class Solution1 {
        /**
         * 方法1 - 枚举
         *
         * @param time
         * @return
         * @author ZJX
         * @date 2024/10/25
         */
        public int countTime(String time) {
            //分钟的可能 3种
            int m = 1;
            char c1 = time.charAt(0), c2 = time.charAt(1), c3 = time.charAt(3), c4 = time.charAt(4);
            if (c3 == '?' && c4 == '?')
                m = 60;
            else if (c4 == '?')
                m = 10;
            else if (c3 == '?')
                m = 6;

            int h = 1;
            if (c1 == '?' && c2 == '?')
                h = 24;
            else if (c2 == '?')
                h = c1 == '2' ? 4 : 10;
            else if (c1 == '?')
                h = c2 >= '5' ? 2 : 3;

            return m * h;
        }
    }


    class Solution2 {

        int res = 0;

        public int countTime(String time) {
            char[] s = time.toCharArray();
            backtrack(s, 0);
            return res;
        }

        private void backtrack(char[] s, int pos) {
            if (pos == s.length) {
                if (check(s)) {
                    res++;
                }
                return;
            }

            if (s[pos] == '?') {
                for (char i = '0'; i <= '9'; i++) {
                    s[pos] = i;
                    backtrack(s, pos + 1);
                    s[pos] = '?';
                }
            } else
                backtrack(s, pos + 1);
        }

        private boolean check(char[] s) {
            int hh = (s[0] - '0') * 10 + s[1] - '0';
            int mm = (s[3] - '0') * 10 + s[4] - '0';
            return hh < 24 && mm < 60;
        }
    }
}
