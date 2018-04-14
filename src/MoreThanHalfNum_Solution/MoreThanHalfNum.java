package MoreThanHalfNum_Solution;
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

class Solution{
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0 || array == null)
            return 0;

        int result = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i ++){
            if(count == 0){
                result = array[i];
                count = 1;
            }
            else{
                if(array[i] == result)
                    count ++;
                else
                    count --;
            }
        }
        System.out.println(result);
        count = 0;
        for(int i = 0; i < array.length; i ++){
            if(result == array[i])
                count ++;
        }
        System.out.println(count);
        if(count * 2 <= array.length)
            result = 0;
        return result;
    }
}

public class MoreThanHalfNum {
    public static void main(String[] args){
        int[] array = {4, 2, 4, 1, 4, 2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }
}
