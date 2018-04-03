package printMatrix;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

import java.util.ArrayList;

class Solution{
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        int minRow = 0;
        int maxRow = matrix.length - 1;
        while(minCol <= maxCol && minRow <= maxRow){
            for(int i = minCol; i <= maxCol; i ++)
                res.add(matrix[minRow][i]);
            minRow ++;

            for(int j = minRow; j <= maxRow; j ++)
                res.add(matrix[j][maxCol]);
            maxCol --;

            if(minRow <= maxRow){
                for(int i = maxCol; i >= minCol; i --)
                    res.add(matrix[maxRow][i]);
                maxRow --;
            }
            if(minCol <= maxCol){
                for(int i = maxRow; i >= minRow; i --)
                    res.add(matrix[i][minCol]);
                minCol ++;
            }
        }
        return res;
    }
}

public class printMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix1 = {{1, 2, 3, 4, 5}};
        System.out.println(new Solution().printMatrix(matrix1));
    }
}
