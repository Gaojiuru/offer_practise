package GetNext;
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class Solution{
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;
        TreeLinkNode pNext = null;
        if(pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while(pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        }
        else if(pNode.next != null){
            TreeLinkNode pParent = pNode.next;
            TreeLinkNode pCurrent = pNode;
            while(pParent != null && pCurrent == pParent.right){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}

public class GetNext {
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode l = new TreeLinkNode(2);
        TreeLinkNode r = new TreeLinkNode(3);
        TreeLinkNode ll = new TreeLinkNode(4);
        TreeLinkNode lr = new TreeLinkNode(5);
        TreeLinkNode lrl = new TreeLinkNode(8);
        TreeLinkNode lrr = new TreeLinkNode(9);
        TreeLinkNode rl = new TreeLinkNode(6);
        TreeLinkNode rr = new TreeLinkNode(7);
        root.left = l;
        l.next = root;
        root.right = r;
        r.next = root;
        l.left = ll;
        ll.next = l;
        l.right = lr;
        lr.next = l;
        lr.left = lrl;
        lrl.next = lr;
        lr.right = lrr;
        lrr.next = lr;
        r.left = rl;
        rl.next = r;
        r.right = rr;
        rr.next = r;
        System.out.println(new Solution().GetNext(r).val);
    }
}
