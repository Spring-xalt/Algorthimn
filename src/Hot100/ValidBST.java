package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 98 验证二叉搜索树
 */
public class ValidBST {
    List<Integer> l=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        checkBST(root);
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)){
                return false;
            };
        }
        return true;
    }
    public void checkBST(TreeNode root) {
        if(root==null){
            return;
        }
        checkBST(root.left);
        l.add(root.val);

        checkBST(root.right);
    }
}
