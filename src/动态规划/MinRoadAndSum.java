package 动态规划;

import java.util.Arrays;

public class MinRoadAndSum {
    int[] result;
    int[][] testResult;

    public int minFallingPathSum(int[][] matrix) {
        int i = matrix.length-1;
        int j = matrix[0].length-1;
        testResult = new int[i+1][j+1];
        for (int h = 0; h <= i; h++) {
            Arrays.fill(testResult[h], 66666);
        }
        Arrays.fill(testResult,66666);
        result = new int[j+1];
        for (int k = 0; k <=j; k++) {
            result[k] = dp(matrix, i, k);
        }
        Arrays.sort(result);
        return result[0];
    }

    public int dp(int[][] matrix, int i, int j) {
        if (j < 0 || i < 0 || j > matrix[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j <= matrix[0].length-1) {
            return matrix[0][j];
        }
        if(testResult[i][j]!=66666){
            return testResult[i][j];
        }
        int min = Math.min(dp(matrix, i - 1, j - 1) , dp(matrix, i - 1, j));
        min = Math.min(min, dp(matrix, i - 1, j + 1))+ matrix[i][j];
        testResult[i][j]=min;
        return min;
    }

    public static void main(String[] args) {
        MinRoadAndSum sum = new MinRoadAndSum();
        int[][] aa = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        sum.minFallingPathSum(aa);
        System.out.println("");
    }
}
