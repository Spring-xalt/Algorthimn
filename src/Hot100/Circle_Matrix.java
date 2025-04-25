package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 54 螺旋矩阵
 */
public class Circle_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        // 非常经典的一个move数组加k来决定方向以及转换方向

        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        boolean [][]visited=new boolean[m][n];
        // 由k和 move数组决定一般的移动方向 k%来转换方向
        int k=0;
        int i=0,j=0;
        int nextI,nextJ;
        for(int x=0;x<m*n;x++){
            //总共m*n个元素 正常来说每个都应当遍历到
            int [][]move=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};  //分别对应移动方向 右 下 左 上
            list.add(matrix[i][j]);
            visited[i][j]=true;
            // 正常来说直接左右移动
            nextI=i+move[k][0];
            nextJ=j+move[k][1];
            //若下一步越界或者已经访问过 转换方向
            if(nextI<0||nextJ<0||nextI>=m||nextJ>=n||visited[nextI][nextJ]){
                // 转换方向
                k=(k+1)%4;

                nextI=i+move[k][0];
                nextJ=j+move[k][1];
            }
            i=nextI;
            j=nextJ;
        }
        return list;
    }
    public static List<Integer> spiralOrder2(int[][] matrix) {
        // 非常牛比的 跟着题目模拟的 螺旋式进入最深处 不会往外走 一直向内
        // 分别定义上下左右边界 并随着螺旋向内延申 边界动态变化
        int l=0,r=matrix[0].length-1;
        int u=0,d=matrix.length-1;
        Integer []res=new Integer[(r+1)*(d+1)];
        int x=0;
        while(true){
                for(int i=l;i<=r;i++){
                    res[x++]=matrix[u][i];
                }

            //上到下
                if(++u>d){ //为接下来 从上到下准备 防止越界
                    break;
                }
                for(int i=u;i<=d;i++){
                    res[x++]=matrix[i][r];
                }
            // 右到左
                if(l>--r){// 为从右到左防止越界
                    break;
                }
                for(int i=r;i>=l;i--){
                    res[x++]=matrix[d][i];
                }
            // 下到上
                if(--d<u){
                    break;
                }
                for(int i=d;i<=u;i++){
                    res[x++]=matrix[i][l];
                }

            //和上面一起 从右到左
                if(++l>r){
                    break;
                }

        }
        return Arrays.asList(res);
    }
    public static void main(String[] args) {
        System.out.println(spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
