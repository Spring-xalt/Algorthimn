package Hot100;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 105 利用先序遍历和中序遍历构建二叉树
 */
public class MakeTree {
    Map<Integer,Integer> m=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return getRoot(preorder,inorder,0,inorder.length-1,0);
    }
    public TreeNode getRoot(int []fir,int []mid,int l,int r, int begin) {
        //begin应当指示每次进入新一层时的根节点下标(在先序遍历中的下标)
        if(l>r){
            return null;
        }
        //得到当前层根结点
        TreeNode root=new TreeNode(fir[begin]);
        //得到当前根节点在中序中的位置index
        int index=m.get(fir[begin]);

        root.left=getRoot(fir,mid,l,index-1,begin+1);
        // 根左右 左的begin位置+1
        //       右侧的begin要根据左子树的节点数算(先序中的begin到右子树起始点:  )
        root.right=getRoot(fir,mid,index+1,r,begin+index-l+1);
        return root;
        //回溯返回根节点
    }
}
