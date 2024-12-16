package Lc_mid.SlidingTheWindow;
//LC 1423最大点数
public class BiggestPonit {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,79,80,1,1,1,200,1},3));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=cardPoints[i];
        }
        int ans=0,count=0,l=0;
        for(int i=0;i<n-k;i++){
            count+=cardPoints[i];
        }
        ans=count;
        for(;l+n-k<cardPoints.length;l++){
            int flag=cardPoints[l+n-k]-cardPoints[l];
            count+=flag;
            ans=Math.min(ans,count);
        }
        return (sum-ans);
    }
}
