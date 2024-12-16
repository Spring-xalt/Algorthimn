package Lc_mid.DP;

public class MaxSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbb"));
    }
    public static String longestPalindrome(String s) {
        //dp[i][j]表示子串从i到j为回文串，dp[i][j]为回文需要s[i]==s[j]且dp[i+1][j-1]为回文
        char[]arr=s.toCharArray();
        int n=arr.length;
        int max=0;
        int maxLeft=0,maxRight=0;
        boolean[][]dp=new boolean[n][n];
        //单字符
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        //双字符
        for(int i=0;i<n-1;i++){
            if (arr[i]==arr[i+1]) {
                dp[i][i+1]=true;
                max=2;
                maxLeft=i;
                maxRight=i+1;
            }
        }
        //长度为3以及以上
        for (int length=3; length<=n; length++) {
            for (int i =0; i<=n-length;i++) {
                int j=i+length-1; // 右边界
                if (arr[i]==arr[j]&&dp[i+1][j-1]) {
                    dp[i][j]=true;
                    if (length>max) {
                        max=length;
                        maxLeft=i;
                        maxRight=j;
                    }
                }
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }
}
