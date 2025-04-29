package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 101 对称二叉树
 */
public class SymmetricTree {
    // 分析易得 对称二叉树的中序遍历是回文的  但只关注值是不对的 要关注树的结构
    public static boolean isSymmetric(TreeNode root) {
        List<Integer> t=new ArrayList<>();
        getNum(root,t);
        for(int i=0,j=t.size()-1;i<j;i++,j--){
            if(!t.get(i).equals(t.get(j))){
                return false;
            }
        }
        return true;
    }
    public static void getNum(TreeNode root,List<Integer> t) {
        if(root==null) {
            t.add(-101);
            return;
        }
        getNum(root.left,t);
        t.add(root.val);
        getNum(root.right,t);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric2(TreeNode root){
        return check(root.left,root.right);
    }
    public static boolean check(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        //只有一侧有元素
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        if(!((check(left.left,right.right))&&check(left.right,right.left))){
            return false;
        }
        return true;
    }
}
