package Lc_mid.DataStcuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Lc 236 二叉树的最近祖先
public class BinarySFather {
    // 超时了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        dfs(root,p,list1);
        dfs(root,q,list2);
        int i=0;
        for(;i<list1.size()&&i<list2.size();i++){
            if(list1.get(i).val != list2.get(i).val){
                i--;
                break;
            }
        }
        return list1.get(i);
    }
    public boolean dfs(TreeNode root, TreeNode p, List<TreeNode> a) {
        if(root==null) {
            return false;
        }
        a.add(root);
        if(root==p) {
            return true;
        }
        if(dfs(root.left,p,a)||dfs(root.right,p,a)){
            a.remove(a.size()-1);
            return true;
        }
        return false;
    }
    // 直接用递归思考问题
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) {
            return root;
        }
        // 整体思考 对当前根节点 左右子树 的最近 公共祖先
        TreeNode left=lowestCommonAncestor2(root.left,p,q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        // 只要有公共祖先 root一定是保证 向下而言 最近的就是
        if(left!=null&&right!=null) {
            return root;
        }
        return left!=null?left:right;
    }
}
