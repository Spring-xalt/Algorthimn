package Hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc  437 路经总和3
 */
public class roadSum3 {
    Map<Long,Integer> map;
    int t;
    public int pathSum(TreeNode root, int targetSum) {
        t=targetSum;
        map=new HashMap<>();
        map.put(0L,1);
        return getAns(root,0);
    }
    public int getAns(TreeNode root, long sum) {
        // 前缀树到当前结点时 表示以当前结点为终止结点的值为t的前缀树数目
        if(root==null){
            return 0;
        }
        int ans=0;
        // 计算到当前的前缀树和
        sum+=root.val;

        //前缀和 即要找到 当前sum(当前节点到根节点的值之和)-前面某个结点的sum == target
        //结合两数之和的思路 cursum-presum=t   presum=cursum-t 前面的presum已经记录了值为presum的路径数目
        ans=map.getOrDefault(sum-t,0);
        // 接着记录到当前节点值为cursum的成立数目
        map.put(sum,map.getOrDefault(sum,0)+1);
        int l=getAns(root.left,sum);
        int r=getAns(root.right,sum);
        //最后的回溯  需要在当前节点走完之后除去自身 毕竟一颗右子树的子节点不可能到达左子树
        map.put(sum,map.getOrDefault(sum,0)-1);
        return ans+l+r;
    }
}
