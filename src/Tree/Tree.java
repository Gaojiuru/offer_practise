package Tree;
//请实现两个函数，分别用来序列化和反序列化二叉树

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

class Solution{
    private StringBuilder sb = new StringBuilder();
    private int index = -1;
    String Serialize(TreeNode root){
        if(root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    TreeNode Deserialize(String str){
        index ++;
        if(index >= str.length())
            return null;
        String[] s = str.split(",");
        TreeNode node = null;
        if(!s[index].equals("$")){
            node = new TreeNode(Integer.valueOf(s[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }


}

public class Tree {
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
        System.out.println(new Solution().Serialize(root));
    }
}
