package Lc_mid.DP;
// Lc 2684 矩阵中的最大移动次数
    //注意：要从第一列开始,所以除了从第一列的元素开始的以外，只要靠左的dp[][j-1]全部为-1，则为dp[][j]也为-1
public class TheMostMovingTime {
    public static void main(String[] args) {
        System.out.println(maxMoves(new int [][]{{187,167,209,251,152,236,263,128,135},
                                                 {267,249,251,285,73,204,70,207,74},
                                                 {189,159,235,66,84,89,153,111,189},
                                                 {120,81,210,7,2,231,92,128,218},
                                                 {193,131,244,293,284,175,226,205,245}}));
    }
    public static int maxMoves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]dp=new int[m][n];
        //dp[i][j] 表示到达 i,j位置已经获得的最大次数
        int max=0;
        //第一列不可能被到达，只能作为起点
        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }

        for(int j=1;j<n;j++){
            if(grid[0][j-1]>=grid[0][j]&&grid[1][j-1]>=grid[0][j]){
                dp[0][j]=-1;
            }
            else{
                if(dp[0][j-1]!=-1||dp[1][j-1]!=-1){
                    dp[0][j]=Math.max(dp[0][j-1],dp[1][j-1])+1;
                }
                else{
                    dp[0][j]=-1;
                }
            }
            max=Math.max(max,dp[0][j]);
            if(grid[m-1][j-1]>=grid[m-1][j]&&grid[m-2][j-1]>=grid[m-1][j]){
                dp[m-1][j]=-1;
            }
            else{
                if(dp[m-1][j-1]!=-1||dp[m-2][j-1]!=-1){
                    dp[m-1][j]=Math.max(dp[m-1][j-1],dp[m-2][j-1])+1;
                }
                else{
                    dp[m-1][j]=-1;
                }
            }
            max=Math.max(max,dp[m-1][j]);
        }
        for(int j=1;j<n;j++){
            for(int i=1;i<m-1;i++){
                if(grid[i][j-1]>=grid[i][j]&&grid[i-1][j-1]>=grid[i][j]&&grid[i+1][j-1]>=grid[i][j]){
                    dp[i][j]=-1;
                }
                else{
                    if(dp[i][j-1]!=-1||dp[i-1][j-1]!=-1||dp[i+1][j-1]!=-1){
                        dp[i][j]=Math.max(dp[i][j-1],Math.max(dp[i-1][j-1],dp[i+1][j-1]))+1;
                    }
                    else{
                        dp[i][j]=-1;
                    }
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
