import java.util.Scanner;
//图像物体的边界
public class PictureBianJie {
    static int m, n;
    static int[][] matrix;

    // 上、下、左、右、左上、左下、右上、右下的横坐标、纵坐标偏移量
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution());
    }

    public static int solution() {
        // 标记边界点，将5周围1更改为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 5) continue;

                for (int[] offset : offsets) {
                    int newI = i + offset[0];
                    int newJ = j + offset[1];

                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == 1) {
                        matrix[newI][newJ] = 0;
                    }
                }
            }
        }

        // 记录独立的边界数量
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (i,j)是边界点，dfs(i,j)找出该边界的其他点，并标记该边界上所有点为访问过的状态（即节点值由0更改为1）
                if (matrix[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    // 深度优先搜索, 找出相连边界点
    public static void dfs(int i, int j) {
        matrix[i][j] = 1; // 标记为访问过

        for (int[] offset : offsets) {
            int newI = i + offset[0];
            int newJ = j + offset[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == 0) {
                dfs(newI, newJ);
            }
        }
    }
}