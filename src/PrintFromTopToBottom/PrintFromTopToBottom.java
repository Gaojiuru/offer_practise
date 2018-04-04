package PrintFromTopToBottom;
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class Solution{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return result;
    }
}

public class PrintFromTopToBottom {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(10);
        root.left = l;
        root.right = r;
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        l.left = ll;
        l.right = lr;
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().PrintFromTopToBottom(root));
    }
}
