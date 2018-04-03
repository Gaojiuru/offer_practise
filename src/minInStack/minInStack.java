package minInStack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数

import java.util.Stack;

class Solution{
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node){
        data.push(node);
        if(min.isEmpty() || node < min.peek())
            min.push(node);
        else
            min.push(min.peek());
    }

    public void pop(){
        if(data.isEmpty() && min.isEmpty())
            return;
        data.pop();
        min.pop();
    }

    public int top(){
        return data.peek();
    }

    public int min(){
        return min.peek();
    }
}

public class minInStack {
    public static void main(String[] args){
        Solution s = new Solution();
        s.push(3);
        s.push(4);
        s.push(2);
        s.push(1);
        s.pop();
        s.pop();
        s.push(0);
        System.out.println(s.top());
        System.out.println(s.min());
    }
}
