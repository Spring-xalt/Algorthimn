package WeekCompetition;
//  Lc 3301
import java.util.Arrays;
// 周赛140 t2 贪心 高度互不相同的最大塔高和
public class MaxPowerHeight {
    public static void main(String[] args) {
        System.out.println(maximumTotalSum(new int[]{2,2,1}));
    }
    public static long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n=maximumHeight.length;
        int []value=new int[n];
        value[n-1]=maximumHeight[n-1];
        long max=value[n-1];
        for(int i=n-2;i>=0;i--){
            value[i]=maximumHeight[i];
            if(value[i]>=value[i+1]) {
                value[i]=value[i+1]-1;
                if(value[i]<1){
                    return -1;
                }
            }
            max+=value[i];
        }
        return max;
    }
}
