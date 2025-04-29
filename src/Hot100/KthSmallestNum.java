package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 230 二叉搜索树中第K小的元素
 */
public class KthSmallestNum {
    List<Integer> l=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        getKNum(root,k);
        return l.get(k-1);
    }
    public void getKNum(TreeNode root, int k) {
        if(root==null){
            return;
        }
        getKNum(root.left,k);
        l.add(root.val);
        getKNum(root.right,k);
    }
}
