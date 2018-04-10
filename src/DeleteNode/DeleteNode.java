package DeleteNode;
//给定单向链表额头指针和一个结点指针，定义一个函数在O（1）时间删除该结点。

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}

class Solution{
    public ListNode DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null)
            return null;
        ListNode temp = head;
        //只有一个结点
        if(temp.next == null){
            if(temp.val == toBeDeleted.val)//头结点为删除节点
                temp = null;
            else
                return head;
        }

        if(temp.val == toBeDeleted.val) {
            head = temp.next;
            //return head;
        }

        while(temp.next.next != null){
            if(temp.next.val == toBeDeleted.val)
                break;
            else
                temp = temp.next;
        }

        if(temp.next.next != null)
            temp.next = temp.next.next;
        else if (temp.next.val == toBeDeleted.val)
            temp.next = null;
        return head;
    }
}


public class DeleteNode {
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode temp = null;

        for (int i = 1; i < 8; ++i) {
            ListNode add = new ListNode(i);
            if (i == 1) {
                head.next = add;
            } else {
                temp.next = add;
            }

            temp = add;
        }

        head = new Solution().DeleteNode(head, new ListNode(8));
        temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
