package WeekCompetition._20241229;

public class M {
    public static void main(String[] args) {
        System.out.println(m(100));
    }
    public static int m(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
            if(sum%100==0)return i;
        }
        return -1; 
    }
}
