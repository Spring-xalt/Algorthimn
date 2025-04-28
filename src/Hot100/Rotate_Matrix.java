package Hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 48 旋转图像
 */
public class Rotate_Matrix {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // 我们思考 翻转90度后的矩阵 对于第一行第二列下标为 (1,2)的元素 会到第二行的最后一列 即(2,last)
            //随即对于 (i,j) 号元素 会变为(j,n-1-i)
                    // (n-1-j,i)       (i,j)
        // 故我们可以设置一个间接存储的矩阵
        int [][]matrix_=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix_[i][j]=matrix[n-1-j][i];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=matrix_[i][j];
            }
        }
    }
}
