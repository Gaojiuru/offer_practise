package EntryNodeOfLoop;
//一个链表中包含环，请找出该链表的环的入口结点。

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p1 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

}

public class EntryNodeOfLoop {
    public static void main(String[] args){
        ListNode pHead = new ListNode(0);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        pHead.next = p1;
        p1.next = p2;
        ListNode temp = p2;
        for(int i = 3; i < 7; i ++){
            ListNode add = new ListNode(i);
            temp.next = add;
            temp = temp.next;
        }
        ListNode last = new ListNode(7);
        temp.next = last;
        last.next = p2;
        System.out.println(new Solution().EntryNodeOfLoop(pHead).val);
    }
}
