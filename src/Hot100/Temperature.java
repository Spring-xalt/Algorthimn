package Hot100;

import java.util.Arrays;

// lc 739 每日温度
public class Temperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        // 暴力遍历 过不了 73,74,75,71,69,72,76,73  有重复部分需要处理，71的2在75时同样重复了 需要跳过
        int n=temperatures.length;
        if(n==0) {
            return new int[]{0};
        }
        int []ans=new int[n];
        int i=0;
        while(i<n-1){
            int j=i+1;
            while(j<n){
                if(temperatures[i]<temperatures[j]){
                    ans[i]=j-i;
                    i++;
                    break;
                }
                else{
                    j++;
                    if(j==n) {
                        i++;
                    }
                }
            }
        }
        return ans;
    }
    public static int[] dailyTemperatures2(int[] temperatures) {
        // 记忆化跳跃
        int n=temperatures.length;
        if(n==0) {
            return new int[]{0};
        }
        int []ans=new int[n];
        for(int i=n-2;i>=0;i--){
            int j=i+1;
            while(j<n){
                if(temperatures[i]<temperatures[j]){
                    ans[i]=j-i;
                    break;
                }
                else{
                    // 关键在于此处 ，遇到前一项不小于后一项，j的跳动距离
                    j+=(ans[j]!=0)?ans[j]:1;
                }
            }
        }
        return ans;
    }
}
