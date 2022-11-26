public class findLongestPalindrome {
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            String result = "";
            for (int i = 0; i < s.length(); i ++) {
                dp[i][i] = true;
                result = String.valueOf(s.charAt(i));
            }

            for (int i = 0; i < s.length(); i ++) {
                if (i < s.length() - 1) {
                    Character s1 = s.charAt(i);
                    Character s2 = s.charAt(i + 1);

                    if (s1 == s2) {
                        dp[i][i+1] = true;
                        result = s1+""+s2;
                    }
                }
            }


            //0 ~ 2, 1 ~3, 2~4
            //0 ~ 3, 1 ~4
            //0 ~ 4

            int start = 0;
            int end = 2;

            while (end < s.length()) {
                int i = start;
                int j = end;
                //
                while(j < s.length()) {
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        String candidate = (s.substring(i,j + 1));
                        dp[i][j] = true;
                        if (candidate.length() > result.length()) {
                            result = candidate;
                        }
                    }
                    i ++;
                    j ++;
                }
                end ++;
            }
            return result;
        }
}
