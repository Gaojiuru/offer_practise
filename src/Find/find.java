package Find;
//在一个二维数组中，每一行都是按照从左到右递增的顺序排序，每一列都是按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

class Solution{
    public static boolean find(int[][] array, int key){
        boolean found = false;
        if(array == null || array[0].length == 0)
            return false;
        int row = 0;
        int cols = array[0].length - 1;
        while(row < array.length && cols >= 0) {
            if (key < array[row][cols])
                cols--;
            else if (key > array[row][cols])
                row++;
            else {
                found = true;
                break;
            }
        }
        return found;
    }
}

public class find {
    public static void main(String[] args){
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Solution.find(array, 3));
    }
}
