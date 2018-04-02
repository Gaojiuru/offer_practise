package ReverseList;

//输入一个链表，反转链表后，输出链表的所有元素。

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode RevereList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode pNode = head;
        while(pNode != null){
            ListNode pnext = pNode.next;
            if(pnext == null)
                reverseHead = pNode;
            pNode.next = pre;
            pre = pNode;
            pNode = pnext;
        }
        return reverseHead;
    }
}

public class ReverseList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i < 6; i ++){
            ListNode add = new ListNode(i);
            temp.next = add;
            temp = add;
        }
        temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();

        head = new Solution().RevereList(head);
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
