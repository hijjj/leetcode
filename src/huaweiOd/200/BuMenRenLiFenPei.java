import java.util.Arrays;
import java.util.Scanner;

public class BuMenRenLiFenPei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = Integer.parseInt(sc.nextLine());
        int[] requirements =
                Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(m, requirements));
    }

    public static long getResult(int m, int[] requirements) {
        Arrays.sort(requirements);

        int n = requirements.length;

        int l = n - m - 1;
        int r = n - m;

        int ans = requirements[n - 1];

        while (l >= 0) {
            ans = Math.max(ans, requirements[l] + requirements[r]);
            l--;
            r++;
        }

        return ans;
    }
}