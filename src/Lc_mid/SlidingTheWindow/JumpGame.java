package Lc_mid.SlidingTheWindow;

/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 55 跳跃游戏
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            // 到达了能到的最远地方
            if(i>maxLength) {
                return false;
            }
            maxLength = Math.max(maxLength, nums[i]+i);
            if(maxLength >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
