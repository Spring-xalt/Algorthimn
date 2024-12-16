package Hot100;
//  很有价值的 不能一直贪心 会找不开钱
// 背包问题
import java.util.Arrays;
// Lc 322 零钱兑换
public class ChangeTheMoney {
    public static void main(String[] args) {
        System.out.println(coinChange2(new int[]{186,419,83,408},6249));
        // 排序完后 83,186,408,419
    }
    public static int coinChange(int[] coins, int amount) {
        // 不对 ,一直贪心这样可能为了尽可能少找钱，导致找不开钱
        // 需要加一个 回退的过程 ，遇到不能实现的时候 回溯一个硬币
        int n=coins.length;
        int ans=0;
        Arrays.sort(coins);
        if(amount==0) {
            return 0;
        }
        if(amount<coins[0]) {
            return -1;
        }
        for(int i=n-1;i>=0;i--){
            while(i>0&&amount<coins[i]){
                i--;
                if(i==0&&amount<coins[i]) {
                    return -1;
                }
            }
            ans+=amount/coins[i];
            amount%=coins[i];
        }
        return (amount==0)?ans:-1;
    }

    public static int coinChange2(int[] coins, int amount){
        // 对于 coins[j] 取两者之间最小值
                // 如果取coins[j], 剩余的钱是 i-coins[j] ,此时最小是 dp[i]=dp[i-coins[j]]+1
                // 如果不取 coins[j] 剩余钱是 i, 此时最小 dp[i]=dp[i]
        int n=coins.length;
        // dp[i]表示 用coins[]数组实现金额为i的最小硬币数目
        int []dp=new int[amount+1];
        // 先将他们赋为 amount+1 ,这个是不可能实现的(即使全部是1最值也是 amount)
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        // dp[amount]不变表示赋值不到该值，无法实现
        return (dp[amount]==amount+1)?-1:dp[amount];
    }
    public static int coinChange3(int[] coins, int amount){
        return 0;
    }

}
