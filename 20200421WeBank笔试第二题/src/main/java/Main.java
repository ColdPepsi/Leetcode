import java.util.Scanner;

/**
 * @author WuBiao
 * @date 2020/4/21 21:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            char[] chars = scanner.next().toCharArray();
            int[] count = new int[26];
            for (char aChar : chars) {
                count[aChar - 'a']++;
            }
            int odd = 0;
            for (int value : count) {
                if (value % 2 == 1) {
                    odd++;
                }
            }
            if (odd < 2) {
                System.out.println("Cassidy");
            } else if (odd % 2 == 1) {
                System.out.println("Cassidy");
            } else {
                System.out.println("Eleanore");
            }
        }
    }
}