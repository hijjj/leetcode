package 移除数组;

public class SpiralMatrix {
    int current = 1;
    int i = 1;

    int[][] nums;

    public int[][] generateMatrix(int n) {
        nums = new int[n][n];
        while (current <= n * n) {
            for (int top = i - 1; top <= n - i; top++) {
                nums[i - 1][top] = current;
                current++;
            }
            for (int right = i; right <= n - i; right++) {
                nums[right][n - i] = current;
                current++;
            }
            for (int down = n - i - 1; down >= i - 1; down--) {
                nums[n - i][down] = current;
                current++;
            }
            for (int left = n - i - 1; left > i - 1; left--) {
                nums[left][i - 1] = current;
                current++;
            }
            i++;
        }
        return nums;
    }
}

