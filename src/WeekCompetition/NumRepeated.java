package WeekCompetition;

import java.util.HashMap;


// 周赛415
// 数字小镇捣蛋鬼
public class NumRepeated {
    public int[] getSneakyNumbers(int[] nums) {
        int []flag=new int[2];
        int n=nums.length;
        boolean f=false;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!m.containsKey(nums[i])){
                m.put(nums[i],1);
            }
            else{
                m.put(nums[i],m.get(nums[i])+1);
                if(!f){
                    flag[0]=nums[i];
                    f=true;
                }
                else{
                    flag[1]=nums[i];
                }
            }
        }
        return flag;
    }
}
