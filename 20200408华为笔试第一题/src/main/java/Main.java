import java.util.Scanner;

/**
 * @author WuBiao
 * @date 2020/4/8 19:15
 */
public class Main {

    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int L = scanner.nextInt();
            if (N == 0 && L == 0) {
                return;
            }
            System.out.println(cal(N, L));
        }
    }

    private static long cal(int n, int l) {
        long res = 0;
        long temp = 1;
        for (int i = 1; i <= l; i++) {
            temp = ((temp % MOD) * n) % MOD;
            res += temp;
            res %= MOD;
        }
        return res;
    }
}