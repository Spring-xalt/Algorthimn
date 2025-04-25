package Lc_mid.Matirx;

import Hot100.KMaxNumInArr;

import java.util.HashMap;
import java.util.Iterator;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 73 矩阵置0
 */
public class MatrixZero {
    public static void setZeroes(int[][] matrix) {
        // 法一:  O(n^2)  O(n)
        // 以第一行 或者第一列为坐标轴的横纵坐标 如果坐标轴上没有0 则以后每次就把 对应点在坐标的映射设置为0 坐标轴上有0 时取一个min值作为label
        boolean rowArr[]=new boolean[matrix[0].length];  //横着的
        boolean colArr[]=new boolean[matrix.length];     //竖着的
        // 把第一行第一列的元素置为0的逻辑放在一个两个arr中
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                // colArr 表示第i行首位元素为0  需要调整
                colArr[i]=true;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                // rowArr 表示第i列的首位元素为0
                rowArr[i]=true;
            }
        }
        for(int i=1;i<matrix.length;i++) {
            for(int j=1;j<matrix[0].length;j++) {
                if(matrix[i][j]==0){
                    // 首位置0
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        // 根据坐标映射元素 置中间元素
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                // 对首位为0的每一行 化为0
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                // 对首位为0的每一列
                for(int k=1;k<matrix.length;k++){
                    matrix[k][j]=0;
                }
            }
        }
        // 根据数组 置 坐标轴元素
        boolean hasInCol=false,hasInRow=false;
        for(int i=0;i<matrix.length;i++){
            if(colArr[i]){
                hasInCol=true;
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(rowArr[j]){
                hasInRow=true;
                for(int k=1;k<matrix.length;k++){
                    matrix[k][j]=0;
                }
            }
        }
        if(hasInCol){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(hasInRow){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    public static void setZeroes2(int[][] matrix) {
        // 法二
        // 比法一更清晰 :我们思考 对原来不是0的元素变为0 只可能是行或者列上有一元素为0 故我们可以直接记录行列 用标记数组
                        //相较于法一不用多一个中间步骤映射到0行或者0列
        int m=matrix.length;
        int n=matrix[0].length;
        boolean []col=new boolean[m];   //竖着
        boolean []row=new boolean[n];   //横着
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    col[i]=true;
                    row[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(col[i]||row[j]){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        setZeroes2(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
