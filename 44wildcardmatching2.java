class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0;
        int sLen = s.length(), pLen = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        boolean dp[][] = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for (int j = 1; j <=pLen; j++) {
            dp[0][j] = dp[0][j-1] && (pArr[j-1] == '*');
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pArr[j-1] == sArr[i-1] || pArr[j-1] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pArr[j-1] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[sLen][pLen];
    }
}
