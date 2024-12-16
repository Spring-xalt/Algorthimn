package Lc_mid.SlidingTheWindow;
// LC2024   考试最大困扰度
public class MaxDisturb {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTTTTFTFFT",2));
    }
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int n=answerKey.length();
        int l=0,r=1,ans=0,count=0;
        int t=(answerKey.charAt(0)=='T')?1:0;
        int f=(answerKey.charAt(0)=='F')?1:0;                           //分别记录tf出现次数
        for(;r<n;r++){
            if(answerKey.charAt(r)=='T'){
                t++;
            }
            else{
                f++;
            }
            while(t>k&&f>k){
                //t f出现次数均大于k，表明任何一个变都不能满足，就需要移动左窗口 l
                if(answerKey.charAt(l)=='T'){
                    t--;
                }
                else{
                    f--;
                }
                l++;
            }

            count=r-l+1;
            ans=Math.max(count,ans);
        }
        return (n>1)?ans:0;
    }
}
