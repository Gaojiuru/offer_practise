package PrintTree;
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}

public class PrintTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(10);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().Print(root));
    }
}
