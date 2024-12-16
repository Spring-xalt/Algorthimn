package WeekCompetition;

import java.util.Arrays;

public class SubArrX_Sum {
    public static void main(String[] args) {
        System.out.println(findXSum(new int[]{1,1,2,2,3,4,2,3},6,2));
    }
    public static int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int l=n-k+1;
        int []ans=new int[l];
        for(int i=0;i<l;i++){
            ans[i]=getX_Sum(Arrays.copyOfRange(nums,i,i+k),x);
        }
        return ans;
    }
    public static int getX_Sum(int []nums,int x){
        int l=nums.length;
        Arrays.sort(nums);
        int m=nums[l-1];
        int ans=0;
        int []arr=new int[m+1];
        for(int i=0;i<l;i++){
            arr[nums[i]]++;
        }
        int count=0;
        for(int i=m;i>=0&&x>0;i--){
            if(arr[i]!=0){
                count++;
            }
        }
        if(count>=x){
            Arrays.sort(arr);
            for(int i=m;i>=0;i--){
                ans+=0;
            }
        }
        else{
            for(int i=m;i>=0;i--){
                if(arr[i]!=0){
                    ans+=arr[i]*i;
                }
            }
        }
        return ans;
    }
}
