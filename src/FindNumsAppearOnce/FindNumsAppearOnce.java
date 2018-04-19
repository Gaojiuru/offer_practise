package FindNumsAppearOnce;
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

class Solution{
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]){
        if(array.length < 2)
            return;
        int xor = 0;
        for(int i = 0; i < array.length; i ++)
            xor ^= array[i];
        int indexOf1 = findFirst1(xor);
        for(int i = 0; i < array.length; i ++){
            if(isBit1(array[i], indexOf1))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
        System.out.println(num1[0] + "\t" + num2[0]);
    }

    private int findFirst1(int xor){
        int index = 0;
        while(((xor & 1) == 0) && index < 32){
            xor >>= 1;
            index ++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}

public class FindNumsAppearOnce {
    public static void main(String[] args){
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = {0};
        int num2[] = {0};
        new Solution().FindNumsAppearOnce(array, num1, num2);
    }
}
