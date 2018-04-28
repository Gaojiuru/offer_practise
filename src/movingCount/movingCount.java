package movingCount;
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子?

class Solution{
    //int count = 0;
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < rows * cols; i ++)
            visited[i] = false;
        int count = Helper(threshold, 0, rows, 0, cols, visited);
        return count;
    }

    private int Helper(int threshold, int row, int rows, int col, int cols, boolean[] visited){
        int count = 0;
        if(check(threshold, row, rows, col, cols, visited)){
            visited[row * cols + col] = true;
            count = 1 + Helper(threshold, row + 1, rows, col, cols, visited) +
                    Helper(threshold, row, rows, col + 1, cols, visited) +
                    Helper(threshold, row - 1, rows, col, cols, visited) +
                    Helper(threshold, row, rows, col - 1, cols, visited);
        }
        return count;
    }

    private boolean check(int threshold, int row, int rows, int col, int cols, boolean[] visited){
        if(row >= 0 && row < rows && col >= 0 && col < cols &&  getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col])
            return true;
        return false;
    }

    private int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

public class movingCount {
    public static void main(String[] args){
        int threshold = 5;
        int rows = 10;
        int cols = 10;
        System.out.println(new Solution().movingCount(threshold, rows, cols));
    }
}
