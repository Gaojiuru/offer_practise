package FindContinuousSequence;
//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

import java.util.ArrayList;

class Solution{
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3)
            return res;

        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;
        while(small < mid){
            if(curSum == sum)
                res.add(ContinuousSequence(small, big));

            while(curSum > sum && small < mid){
                curSum -= small;
                small ++;
                if(curSum == sum)
                    res.add(ContinuousSequence(small, big));
            }
            big ++;
            curSum += big;
        }
        return res;
    }

    private ArrayList<Integer> ContinuousSequence(int small, int big){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = small; i <= big; i ++)
            temp.add(i);
        return temp;
    }
}

public class FindContinuousSequence {
    public static void main(String[] args){
        System.out.println(new Solution().FindContinuousSequence(15));
    }
}
