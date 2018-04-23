package deleteDuplication;
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode p = newHead;
        ListNode q = pHead;
        while(q != null && q.next != null){
            if(q.next.val == q.val){
                int temp = q.val;
                while(q != null && q.val == temp)
                    q = q.next;
                p.next = q;
            }
            else {
                p = q;
                q = q.next;
            }
        }
        return newHead.next;
    }
}

public class deleteDuplication {
    public static void main(String[] args){
        ListNode pHead = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(5);
        pHead.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        Solution s = new Solution();
        pHead = s.deleteDuplication(pHead);
        while(pHead != null){
            System.out.print(pHead.val + "->");
            pHead = pHead.next;
        }
    }
}
