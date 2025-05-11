package Hot100;

import java.util.*;

/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 347 前k个高频元素
 */
public class KTimesNum {
    static Map<Integer,Integer>m;

    public static int[] topKFrequent(int[] nums, int k) {
        m = new HashMap<>();
        // 统计频率
        for (int num:nums) {
            m.put(num,m.getOrDefault(num,0)+1);
        }
        // 提取不同元素放入数组（准备建堆）
        int n = m.size();
        int[] heap = new int[n];
        int index = 0;
        //用已有的keyset去重
        for (int num:m.keySet()) {
            heap[index++] = num;
        }
        //从最后一个非叶子节点进入 2*i+1一定可以到达的地方进入 减少遍历范围
        for (int i=n/2-1;i>=0;i--) {
            down(heap,i,n);
        }

        // 取出前k个最大频率的元素
        int[] res = new int[k];
        int size = n;
        for (int i = 0; i < k; i++) {
            res[i] = heap[0];
            // 将堆尾移到堆顶
            heap[0] = heap[--size];
            // 下沉 维护堆
            down(heap, 0, size);
        }
        return res;
    }

    public static void down(int[] arr,int i,int size) {
        int cur=i;
        while (true) {
            int l=cur*2+1;
            int r=cur*2+2;
            int largest=cur;

            if (l<size&&m.get(arr[l])>m.get(arr[largest])) {
                largest=l;
            }
            if (r<size&&m.get(arr[r])>m.get(arr[largest])) {
                largest=r;
            }

            if(largest==cur) {
                break;
            }

            swap(arr,cur,largest);
            cur = largest;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
