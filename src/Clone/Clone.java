package Clone;

//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class Solution{
    private void CloneNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    private void ConnectedSiblingNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = pNode.next;
            if(pNode.random != null)
                pCloned.random = pNode.random.next;
            pNode = pCloned.next;
        }
    }

    private RandomListNode RecconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if(pNode != null){
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while(pNode != null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;

    }

    public RandomListNode Clone(RandomListNode pHead){
        CloneNode(pHead);
        ConnectedSiblingNodes(pHead);
        return RecconnectNodes(pHead);
    }
}

public class Clone {
    public static void main(String[] args){
        RandomListNode pHead = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4 = new RandomListNode(5);
        pHead.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        pHead.random = node2;
        node1.random = node4;
        node3.random = node1;
        new Solution().Clone(pHead);
    }
}
