package WeekCompetition.Double145_20241207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Lc 3376
public class _2 {
    public static int findMinimumTime(List<Integer> strength, int K) {
        int []arr=new int[strength.size()];
        for(int i=0;i<strength.size();i++){
            arr[i]=strength.get(i);
        }
        Arrays.sort(arr);
        int time=0;
        int en=0;
        int x=1;
        for(int i=0;i<arr.length;i++){
            while(en<arr[i]){
                en+=x;
                time++;
            }
            x+=K;
            en=0;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumTime(new ArrayList<Integer>(Arrays.asList(2,5,4)), 2

        ));
    }
}
