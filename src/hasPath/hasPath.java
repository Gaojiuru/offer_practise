package hasPath;
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
// 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

import java.util.Arrays;

class Solution{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || str == null || rows < 1 || cols < 1)
            return false;
        int pathLength = 0;
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < visited.length; i ++)
            visited[i] = false;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(Helper(matrix, i, rows, j, cols, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean Helper(char[] matrix, int row, int rows, int col, int cols, char[] str, int pathLength, boolean[] visted){
        if(pathLength == str.length)
            return true;
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visted[row * cols + col]){
            pathLength ++;
            visted[row * cols + col] = true;
            hasPath = Helper(matrix, row + 1, rows, col, cols, str, pathLength, visted) ||
                    Helper(matrix, row , rows, col + 1, cols, str, pathLength, visted) ||
                    Helper(matrix, row - 1, rows, col, cols, str, pathLength, visted) ||
                    Helper(matrix, row , rows, col - 1, cols, str, pathLength, visted);
            if(!hasPath){
                pathLength --;
                visted[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}

public class hasPath {
    public static void main(String[] args){
        char[] matrix = {'A','B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'};
        int rows = 5;
        int cols = 8;
        String s = "SGGFIECVAASABCEHJIGQEM";
        char[] str = s.toCharArray();
        System.out.println(new Solution().hasPath(matrix, rows, cols, str));
    }
}
