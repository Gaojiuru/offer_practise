package maxInWindow;
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
// 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution{
    public ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0)
            return res;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < num.length; i ++){
            System.out.println(queue);
            while(queue.size() != 0 && num[queue.getLast()] <= num[i])
                queue.pollLast();
            while(queue.size() != 0 && i - queue.getFirst() + 1 > size)
                queue.pollFirst();
            queue.add(i);
            if(size != 0 && i + 1 >= size)
                res.add(num[queue.peekFirst()]);
        }
        return res;
    }
}

public class maxInWindow {
    public static void main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(new Solution().maxInWindows(num, size));
    }
}
