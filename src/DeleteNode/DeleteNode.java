package DeleteNode;
//给定单向链表额头指针和一个结点指针，定义一个函数在O（1）时间删除该结点。

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class Solution{
    public void DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null)
            return;
        ListNode temp = head;
        while (temp.next.val != toBeDeleted.val)
            temp = temp.next;

        if (temp.next.next == null)
            temp.next = null;
        else
            temp.next = temp.next.next;
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

        new Solution().DeleteNode(head, new ListNode(7));
        temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
