package 二分法;

public class XSquareRoot {
    int left = 0;
    int right;
    boolean result = false;

    public boolean mySqrt(int x) {
        right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                result = true;
            } else if ((long)mid * mid > x) {
                right = (mid - 1);
            } else {
                left = (mid + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        XSquareRoot x = new XSquareRoot();
        x.mySqrt(2147395599);
    }
}
