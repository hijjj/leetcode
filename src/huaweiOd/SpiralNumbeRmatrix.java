package huaweiOd;

import java.util.Scanner;
//螺旋数字 good
public class SpiralNumbeRmatrix {
    public void spiralNumberMatrix(int n, int h) {
        int cloumn = n % h == 0 ? n / h : (n / h) + 1;
        int row = h;
        int[][] nums = new int[row][cloumn];
        int count = 1;
        int current = 0;
        while (count <= n) {
            if (cloumn != 1) {
                //上
                for (int top = current; top < cloumn - current; top++) {
                    if (count > n) {
                        break;
                    }
                    nums[current][top] = count;
                    count++;
                }
                //右
                for (int right = current + 1; right < row - current; right++) {
                    if (count > n || cloumn - current - 1 < 0||cloumn - current - 1>cloumn-1) {
                        break;
                    }
                    nums[right][cloumn - current - 1] = count;
                    count++;

                }
                //下
                for (int down = cloumn - current - 2; down >= current; down--) {
                    if (count > n || row - current - 1 < 0||row - current - 1>row-1) {
                        break;
                    }
                    nums[row - current - 1][down] = count;
                    count++;
                }
                //左
                for (int left = row - 2 - current; left > current; left--) {
                    if (count > n) {
                        break;
                    }
                    nums[left][current] = count;
                    count++;

                }
                current++;
                if (current > cloumn - 1 || current > row - 1) {
                    break;
                }
            } else {
                int k = 1;
                for (int i = 0; i < h; i++) {
                    if(k<=h) {
                        System.out.println(k>n?"* ":k+" ");
                        k++;
                    }
                }
                return;
            }
        }
        for (int i = 0; i < row; i++) {
            String s = "";
            for (int j = 0; j < cloumn; j++) {
                int nums1 = nums[i][j];
                if (nums1 == 0) {
                    s = s + "* ";
                } else {
                    s = s + nums1+" ";
                }
            }
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        SpiralNumbeRmatrix spiralNumbeRmatrix = new SpiralNumbeRmatrix();
        spiralNumbeRmatrix.spiralNumberMatrix(num1, num2);
    }
}
