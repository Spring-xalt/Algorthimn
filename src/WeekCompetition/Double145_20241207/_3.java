package WeekCompetition.Double145_20241207;
//  145 双周赛
public class _3 {
    public int minOperations(int n, int m) {
        int []arr1=new int[5];
        int []arr2=new int[5];
        int k=1;
        while(n/k>0){

        }
        return 0;
    }
    public static boolean isZ(int n){
        if(n==2)return true;
        for(int i=2;i<=Math.sqrt(n)+1;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
