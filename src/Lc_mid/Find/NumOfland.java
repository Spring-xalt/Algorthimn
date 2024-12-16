package Lc_mid.Find;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 200 岛屿数量
 */
public class NumOfland {
//    每一次深入dfs结束 就找到一个新岛 dfs不能越界 也不能走走过的地方 用label一下
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid,int i,int j){
        // 越界 或者不是岛屿(水域或者走过) 退回去
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1')return ;

        grid[i][j]='2';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
