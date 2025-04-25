package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 42 接雨水
 */
public class Rain {

    // 法一 :时间O(n) 空间 O(n)  dp思想
    public int trap(int[] height) {
        // 把每一块位置蓄水 都想象为 水桶接水 需要得到 当前高度(height[i]) 与 桶的高度(左右两边前后缀的最小值) 的差
        int n=height.length;
        // 分别得到前后缀的最大值
        int []pre=new int[n];
        int []suf=new int[n];

        pre[0]=height[0];
        suf[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(height[i],pre[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.max(height[i],suf[i+1]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            // 桶的高度
            int h=Math.min(suf[i],pre[i]);
            if(height[i]<h){
                ans+=(h-height[i]);
            }
        }
        return ans;
    }

    // 法二 双指针做法 不用空间存储 前后缀
    public int trap2(int[] height) {
        // 不用多余空间存储前后缀  只需要动态维护一个当前桶高
        int n=height.length;
        int ans=0;
        int l=0,r=n-1;
        int maxL=height[l],maxR=height[r];
        while(l<r){
            if(height[l]<height[r]){
                // 左边为桶高 只需确定当前位置是否可以蓄水即可
                l++;
                maxL=Math.max(maxL,height[l]);
                // 若是maxL 可以蓄水 不是则加0
                ans+=maxL-height[l];
            }
            else{
                r--;
                maxR=Math.max(maxR,height[r]);
                ans+=maxR-height[r];
            }
        }
        return ans;
    }
}
