package ReorderOddEven;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
class Solution1{
    public void reOrderArray(int[] array) {
        if(array == null || array.length <= 1)
            return;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while(isEven(array[left]) && left < right)
                left ++;
            while(left < right && !isEven(array[right]))
                right --;
            if(left < right)
                swap(array, left, right);
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isEven(int number){
        if(number % 2 != 0)
            return true;
        else
            return false;
    }
}

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
class Solution2{
    public void reOrderArray(int[] array) {
        if(array == null || array.length <= 1)
            return;
        int number = 0;
        for(int i = 0; i < array.length; i ++){
            if(isEven(array[i])){
                int j = i;
                while(j > number){
                    swap(array, j- 1, j);
                    j --;
                }
                number ++;
            }
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isEven(int number){
        if(number % 2 != 0)
            return true;
        else
            return false;
    }
}

public class ReorderOddEven {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5};
        int[] temp = array;

        /*new Solution1().reOrderArray(temp);
        for(int i = 0; i < temp.length ; i ++)
            System.out.print(temp[i] + "\t");
        System.out.println();

        temp = array;*/
        new Solution2().reOrderArray(temp);
        for(int i = 0; i < temp.length ; i ++)
            System.out.print(temp[i] + "\t");
    }

}
