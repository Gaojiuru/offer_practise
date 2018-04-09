package Convert;
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。

import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
//非递归
class Solution1{
    public TreeNode Convert(TreeNode pRootOfTree){
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while(p != null || !stack.isEmpty()){
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
             p = stack.pop();
            if(isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            }
            else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return  pRootOfTree;
    }
}
//递归
class Solution2{
    TreeNode pre = null;
    TreeNode lastLeft = null;
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return null;
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null)
            pre.right = pRootOfTree;
        pre = pRootOfTree;
        lastLeft = lastLeft == null ? pRootOfTree : lastLeft;
        Convert(pRootOfTree.right);
        return lastLeft;
    }
}

public class Convert {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(14);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(8);
        TreeNode rr = new TreeNode(16);
        TreeNode rl = new TreeNode(12);

        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;

        //TreeNode res = new Solution1().Convert(root);
        TreeNode res = new Solution2().Convert(root);
        while(res != null){
            System.out.print(res.val + "->");
            if(res.right != null)
                res = res.right;
            else break;
        }
        System.out.println();

        while(res != null){
            System.out.print(res.val + "->");
            if(res.left != null)
                res = res.left;
            else break;
        }
        System.out.println();
    }
}
