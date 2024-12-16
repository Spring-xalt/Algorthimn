package Lc_mid.DP;
 // Lc 1594 矩阵最大非负值
public class MaxRightAnsInJuzhen {
     public int maxProductPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        // dp[i][j]是 i,j位置最大积
        dp[0][0]= grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]*grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]*grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i-1][j]*grid[i][j],dp[i][j-1]*grid[i][j]);
            }
        }
        if(dp[m-1][n-1]>=0)return dp[m-1][n-1];
        else{
            return -1;
        }
     }
}
