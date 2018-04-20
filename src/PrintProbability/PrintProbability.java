package PrintProbability;
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n打印出s的所有可能的值出现的概率。

//递归
class Solution1{
    public void PrintProbability(int n){
        if(n < 1)
            return;
        int maxSum = 6 * n;
        int[] probabilities = new int[maxSum - n + 1];
        for(int i = 0; i < probabilities.length; i ++)
            probabilities[i] = 0;
        Probability(n, probabilities);

        double total = Math.pow(6, n);
        for(int i = n; i <= maxSum; i ++){
            double ratio = (double)probabilities[i - n] / total;
            System.out.println(i + ": " + ratio);
        }
    }

    void Probability(int n, int[] probabilities){
        for(int i = 1; i <= 6; i ++)
            Probability(n, n, i, probabilities);
    }

    void Probability(int original, int current, int sum, int[] probabilities){
        if(current == 1)
            probabilities[sum - original] ++;
        else{
            for(int i = 1; i <=6; i ++)
                Probability(original, current - 1, i + sum, probabilities);
        }
    }
}

//非递归
class Solution2{
    public void PrintProbability(int n){
        if(n < 1)
            return;
        int[][] probabilities = new int[2][n * 6 + 1];
        for(int i = 0; i < n * 6 + 1; i ++){
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        int flag = 0;
        for(int i = 1; i <= 6; i ++)
            probabilities[flag][i] = 1;

        for(int k = 2; k <= n; k ++){
            for(int i = 0; i < k; i ++)
                probabilities[1 - flag][i] = 0;
            for(int i = k; i <= 6 * k; i ++){
                probabilities[1 - flag][i] = 0;
                for(int j = 1; j <= i && j <= 6; j ++)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(6, n);
        for(int i = n; i <= n * 6; i ++){
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i + ": " + ratio);
        }
    }
}

public class PrintProbability {
    public static void main(String[] args){
        new Solution1().PrintProbability(2);
        System.out.println();
        new Solution2().PrintProbability(2);
    }
}
