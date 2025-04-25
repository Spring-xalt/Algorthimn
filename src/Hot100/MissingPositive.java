package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 41 缺失的第一个正数
 */
public class MissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            // 多次原地hash直到满足
            while(nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                // 考虑1--n的数 把实际上是 i+1的数映射到下标i的位置上
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                // 正常来说每个数都应该经过了替换 没有替换的就是缺失的
                return i+1;
            }
        }
        return n+1;
    }
}
