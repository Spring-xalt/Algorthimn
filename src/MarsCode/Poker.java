package MarsCode;

public class Poker {
    public static int[] solution(int n, int max, int[] array) {
        // Edit your code here
        int []arr = new int[14];
        for(int i=0;i<n;i++){
            arr[array[i]]++;
        }
        int l=array.length;
        int numOfA=arr[1];
        int count=0;
        int []ans=new int[2];
           for(int i=13;i>=0;i--){
            // 最大的牌面最小的值的考虑
            if(numOfA>=3){
                count+=3;
                ans[0]=1;
                if(arr[i]>=2){
                    if(max-count>=i*2) {
                        ans[1]=i;
                        return ans;
                    }
                    else if(i==2){
                        ans[0]=0;break;
                    }
                    else{
                        // 当前的既不满足，也没有遍历完，要重新恢复count
                        count=0;
                    }
                }
                else{
                    count=0;
                    if(i==2){ans[0]=0;break;}
                }
            }
            else if(numOfA==2){
                count+=2;
                ans[1]=1;
                if(arr[i]>=3){
                    if(max-count>=i*3) {
                        ans[0]=i;
                        return ans;
                    }
                    else if(i==2){
                        ans[1]=0;break;
                    }
                    else{
                        count=0;
                    }
                }
                else{
                    count=0;
                    if(i==2){
                        ans[1]=0;
                        break;
                    }
                }
            }
            else{
                if(arr[i]>=3){
                    if(max>i*3){
                        ans[0]=i;
                        for(int j=13;j>=0;j--){
                            if(j==i)continue;
                            if(arr[j]>=2&&max-3*i-2*j>=0){
                                ans[1]=j;
                                return ans;
                            }
                            if(j==0&&ans[1]==0){
                                ans[0]=0;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Add your test cases here
        //System.out.println(java.util.Arrays.equals(solution(9, 34, new int[]{6, 6, 6, 8, 8, 8, 5, 5, 1}), new int[]{8, 5}));

        //System.out.println(java.util.Arrays.equals(solution(31, 17, new int[]{11,10,8,1,2,9,13,1,10,6,8,2,9,7,2,9,8,10,9,3,7,13,7,1,1,5,12,10,12,2,5}), new int[]{1, 7}));
        System.out.println(java.util.Arrays.equals(solution(25, 8, new int[]{10,13,9,5,12,10,13,7,1,2,13,3,7,1,5,10,1,5,7,1,7,8,13,10,5}), new int[]{0,0}));
    }
}
