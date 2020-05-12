/**
 * @author WuBiao
 * @date 2020/5/9 10:10
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) {
            return true;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        double k = ((double) (y1 - y2)) / (x1 - x2);
        double b = y1 - k * x1;
        for (int i = 2; i < coordinates.length; i++) {
            double y = y(k, b, coordinates[i][0]);
            if (!equals(y, coordinates[i][1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param a
     * @param b
     * @return boolean
     * @description 判断两个数是否相等
     * @author WuBiao
     * @date 2020/5/9 10:18
     */
    private boolean equals(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    private double y(double k, double b, double x) {
        return x * k + b;
    }
}