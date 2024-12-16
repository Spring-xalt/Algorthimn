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
    public void setZeroes(int[][] matrix) {
        // 以第一行 或者第一列为坐标轴的横纵坐标 如果坐标轴上没有0 则以后每次就把 对应点在坐标的映射设置为0 坐标轴上有0 时取一个min值作为label
        boolean rowArr[]=new boolean[matrix[0].length];
        boolean colArr[]=new boolean[matrix.length];
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                colArr[i]=true;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                rowArr[i]=true;
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
}
