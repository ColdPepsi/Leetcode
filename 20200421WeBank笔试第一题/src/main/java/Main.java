import java.util.Scanner;

/**
 * @author WuBiao
 * @date 2020/4/21 21:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (m % n == 0) {
            System.out.println(0);
        } else if (n > m) {
            int lack = n - m;
            int less = Math.min(a, b);
            System.out.println(less * lack);
        } else {//m>n,看看是赶几个人走还是加几个礼物
            int lack1 = 0;
            for (int i = 1; i < n; i++) {
                double temp = m * 1.0 / (n - i);
                if ((int) temp * (n - i) == m) {
                    lack1 = i;
                    break;
                }
            }
            int lack2 = n - m % n;
            System.out.println(Math.min(lack1 * a, lack2 * b));
        }
    }
}
