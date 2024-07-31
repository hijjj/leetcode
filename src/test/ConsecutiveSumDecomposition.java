package test;

public class ConsecutiveSumDecomposition {
    public static void main(String[] args) {
        int number = 1073741824; // 示例数字，要分解的数
        findConsecutiveSumDecomposition(number);
    }

    /**
     * 找到将数字分解为连续自然数之和的序列
     * @param number 要分解的数字
     */
    public static void findConsecutiveSumDecomposition(int number) {
        boolean found = false; // 标志是否找到符合条件的序列

        // 尝试不同长度的序列 (n)，从 2 开始（因为至少需要两个数）
        for (int n = 2; n <= number; n++) {
            // 根据公式计算起始数字 (k)
            int numerator = number - (n * (n - 1) / 2);
            // 检查 numerator 是否能被 n 整除
            if (numerator % n == 0) {
                int k = numerator / n; // 计算起始数字 (k)

                // 确保 k 是正整数
                if (k > 0) {
                    // 打印连续自然数序列
                    System.out.print("序列: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print((k + i) + " ");
                    }
                    System.out.println(); // 换行
                    found = true; // 标记已经找到符合条件的序列
                }
            }
        }

        // 如果没有找到任何符合条件的序列，输出提示信息
        if (!found) {
            System.out.println("没有找到连续自然数之和为 " + number + " 的序列");
        }
    }
}
