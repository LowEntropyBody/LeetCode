import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int startIndex = 0, endIndex = 0;
        int nowMaxLength = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int k = 0; k < s.length(); k++){
            for(int j = k; j < s.length(); j++){
                int i = j - k;
                if(k == 0){
                    dp[i][j] = true;
                }else if(k == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        if(nowMaxLength < 2){
                            nowMaxLength = 2;
                            startIndex = i;
                            endIndex = j;
                        }
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(nowMaxLength < k + 1){
                            nowMaxLength = k + 1;
                            startIndex = i;
                            endIndex = j;
                        }
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}  
  