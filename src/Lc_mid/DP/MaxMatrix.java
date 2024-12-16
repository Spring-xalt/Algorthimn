package Lc_mid.DP;
// Lc 221 最大正方形
public class MaxMatrix {
    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},
                                                      {'1','0','1','1','1'},
                                                      {'1','1','1','1','1'},
                                                      {'1','0','0','1','0'}}));
    }
    public static int maximalSquare(char[][] matrix) {
        int x=matrix.length;
        int y=matrix[0].length;
        int [][]dp=new int[x][y];
        //dp[i][j]表示以i，j为下标右下角的正方形的边长最大值
        // dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1  因为要尽力满足所有的正方形内都是1，故选最小值
        dp[0][0]=(matrix[0][0]=='0')?0:1;
        int max=dp[0][0];
        for(int i=1;i<x;i++){
            dp[i][0]=(matrix[i][0]=='0')?0:1;
            max=Math.max(max,dp[i][0]);
        }
        for(int j=1;j<y;j++){
            dp[0][j]=(matrix[0][j]=='0')?0:1;
            max=Math.max(max,dp[0][j]);
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                dp[i][j] =(matrix[i][j]=='1') ?(Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1):0;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
