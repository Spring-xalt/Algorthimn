package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 108 将有序数组转换为二叉搜索树
 */
public class TransferToBTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length-1);
    }
    public static TreeNode getBST(int[] nums,int l,int r) {
        // 对于平衡时中点的选取需要注意二分的边界处理
        //对边界情况要理解清楚 既然是设置了闭区间 l=r时是可满足的 需要进入递归
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=getBST(nums,l,mid-1);
        node.right=getBST(nums,mid+1,r);
        return node;
    }


    //debug
    public static void main(String[] args) {
        TreeNode root=sortedArrayToBST(new int[]{-10,-3,0,5,9});
        goMid(root);
    }
    public static void goMid(TreeNode root) {
        if(root==null){
            return;
        }
        goMid(root.left);
        System.out.print(root.val+" ");
        goMid(root.right);
    }
}
