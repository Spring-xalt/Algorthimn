package Hot100;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 240 搜索二维矩阵||
 */
public class SearchTargetInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // dfs 深度过大会爆栈
        Queue<Integer> q=new ArrayDeque<>();
        return searchDfs(matrix,0,0,q,target);
    }
    public static boolean searchDfs(int[][] matrix,int i,int j,Queue<Integer> q, int target) {
        q.offer(matrix[i][j]);
        while(!q.isEmpty()){
            if(q.poll()==target){
                return true;
            }
            if(i<matrix.length-1 ){
                if(matrix[i+1][j]==target){
                    return true;
                }
                else if(matrix[i+1][j]<target){
                    if(searchDfs(matrix,i+1,j,q,target)){
                        return true;
                    }
                }

            }if(j<matrix[i].length-1){
                if(matrix[i][j+1]==target){
                    return true;
                }
                else if(matrix[i][j+1]<target){
                    if(searchDfs(matrix,i,j+1,q,target)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target){
        // bfs实现 也会爆 不用图搜索策略
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<int []> q=new ArrayDeque<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int []cur=q.poll();
            int i=cur[0];
            int j=cur[1];
            if(matrix[i][j]==target){
                return true;
            }

            if(i+1<n){
                if(matrix[i+1][j]==target){
                    return true;
                }
                else{
                    q.offer(new int[]{i+1,j});
                }
            }
            if(j+1<m){
                if(matrix[i][j+1]==target){
                    return true;
                }
                else{
                    q.offer(new int[]{i,j+1});
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix3(int[][] matrix, int target){
        // 结合本题目的条件 从左到右 从上到下都递增 可以用排除法
        int i=0,j=matrix[0].length-1;// 从右上角元素开始
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                // 当前行都小于 target
                i++;
            }
            else{
                //当前列都大于 target
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int [][]{{-1,3}},3));
    }
}
