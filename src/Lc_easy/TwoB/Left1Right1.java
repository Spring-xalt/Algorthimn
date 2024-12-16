package Lc_easy.TwoB;

public class Left1Right1 {
    //二分法注意 三种情况 左闭右闭 左闭右开 左开右闭
    int l1F1(int []arr,int target){
        // 左闭右闭
        int n=arr.length;
        int l=0,r=n-1;
        while(l<=r){ //看是否满足 区间合法
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }return -1;
    }
    int L1F0(int []arr,int target){
        // 左闭右开
        int n=arr.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return -1;
    }
    int L0F1(int []arr,int target){
        // 左开右闭
        int n=arr.length;
        int l=0,r=n-1;
        while(l<r){ 
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                l=mid;
            }
            else{
                r=mid+1;
            }
        }
        return -1;
    }
}
