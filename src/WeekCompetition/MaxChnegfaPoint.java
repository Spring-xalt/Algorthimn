package WeekCompetition;
import java.util.Arrays;

// 周赛415
// t2最高乘法得分
public class MaxChnegfaPoint {

    public long maxScore(int[] a, int[] b) {
        //dp
        /*  a = [3,2,5,6]                i
            b = [2,-6,4,-5,-3,2,-7]      j
               把b数组当作系数理解
        对于b数组，从右往左看，若选了最后一个元素，则为从前面元素中选三个一起求点积的最大值，
                                    若没选最后一个元素，则从起前面元素中选四个求点积
                    dfs[i][j]代表截止b数组的第i位 选j个元素得到的最大值
                            注意dfs数组的初始化
                    要求dfs(i,j)=max(dfs(i−1,j),dfs(i−1,j−1)+a[j]⋅b[i])
           */
        int n=b.length;
        long [][]arr=new long[n][4];
        for(long[] i:arr){
            Arrays.fill(i,Long.MIN_VALUE);
        }
        return dfs(n-1,3,a,b,arr);
    }
    private long dfs(int i, int j, int[] a, int[] b, long[][] dp) {
        if (j<0) {          //找到所有四个元素，退出
            return 0;
        }
        if (i<0) {
            return Long.MIN_VALUE/2;
        }
        if (dp[i][j] == Long.MIN_VALUE) {
            //dp[i][j]还未进行计算时
            //递归进入，循环计算
            dp[i][j] = Math.max(dfs(i-1,j,a,b,dp), dfs(i-1,j-1,a,b,dp)+(long)a[j]*b[i]);
        }
        return dp[i][j];
    }
}
