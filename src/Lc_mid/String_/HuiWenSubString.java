package Lc_mid.String_;

// Lc 647 回文子串
public class HuiWenSubString {
    // 1.数据范围小 直接暴力
    public static void main(String[] args) {
        System.out.println(countSubstrings2("abc"));
    }
    public static int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isHuiWen(s.substring(i,j+1))){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean isHuiWen(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))return false;
        }
        return true;
    }

    // 非暴力
    // dp思考 : 1.基态下如何判断的? 2.状态之间如何转移的?
                //1. 单字符一定回文 双字符相等时回文
                //2. 当前字符串回文，则长度加2的字符串也回文 当且仅当 新字符串的前后两个字符相等
    public static int countSubstrings2(String s) {
        int n=s.length();
        int ans=0;
        // dp[i][j]表示从i到j的子字符串回文
        boolean [][]dp=new boolean[n][n];
        // 我们易知 每个字符串至少有 s.length个回文的 再用每个字符作为 基态进行延展求和
        //单字符初始化
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        //双字符初始化
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
        }
        // 对每个单字符开始扩展
        for(int i=0;i<=n;i++){
            int l=i,r=i;
            while(l-1>=0 && r+1<n){
                dp[l-1][r+1]=(s.charAt(l-1)==s.charAt(r+1))&&(dp[l][r]);
                l--;
                r++;
            }
        }
        //对双字符基态进行扩展
        for(int i=0;i<n-1;i++){
            int l=i,r=i+1;
            while(l-1>=0 && r+1<n){
                dp[l-1][r+1]=(s.charAt(l-1)==s.charAt(r+1))&&(dp[l][r]);
                l--;
                r++;
            }
        }
        //记录答案
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j])ans++;
            }
        }
        return ans;
    }
}
