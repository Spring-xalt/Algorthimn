package WeekCompetition._20241229;

public class _1_ {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[][]{
                                                         {3,2,1},
                                                         {2,1,0},
                                                         {1,2,3}
                                                        }));
    }
    public static int minimumOperations(int[][] grid) {
        int count=0;
        for(int i=0;i<grid[0].length;i++){
            int x=grid[0][i];
            for(int j=1;j<grid.length;j++){
                int c=0;
                if(grid[j][i]<=x){
                    c=(x-grid[j][i])+1;
                    grid[j][i]+=c;
                    count+=c;
                }
                x=grid[j][i];
            }
        }
        return count;
    }
}
