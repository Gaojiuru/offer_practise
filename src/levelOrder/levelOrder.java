package levelOrder;

import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution{
    public void levelOrder(TreeNode pRoot){
        if(pRoot == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current = null;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            current = queue.poll();
            System.out.print(current.val + "\t");
            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null)
                queue.offer(current.right);
        }

    }
}

public class levelOrder {
    public static void main(String[] args) {
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
        new Solution().levelOrder(root);
    }
}
