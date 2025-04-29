package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 74 搜索二维矩阵
 */
public class SearchTargetInMartrix {
    // O(n*m)  多此一举 没必要 直接对每一行进行二分即可
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int []arr=new int[m*n];
        // 将矩阵内容复制到 arr中
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i*n+j]=matrix[i][j];
            }
        }
        for(int i=0;i<m*n;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int up=0,down=m-1;
        int l=0,r=n-1;
        while(up<=down){
            int mid=(up+down)/2;
            //当前行最后一个 小于target 移动到下一行
            if(matrix[mid][r]<target){
                up=mid+1;
            }
            else if(matrix[mid][r]==target){
                return true;
            }
            else{
                // 当前行最后一个大于target 则可能在当前行 也可能在上面
                    int mid2=(l+r)/2;
                    if(matrix[mid][mid2]==target){
                        return true;
                    }
                    else if(matrix[mid][mid2]>target){
                        r=mid2-1;
                    }
                    else{
                        l=mid2+1;
                    }

                    if(l>r){
                        // 该mid行遍历完 没有找到
                        down=mid-1;
                        l=0;
                        r=n-1;
                    }
            }
        }
        return false;
    }


}
