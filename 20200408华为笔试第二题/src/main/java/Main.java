import java.util.Scanner;

/**
 * @author WuBiao
 * @date 2020/4/8 20:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            char[] chars = scanner.next().toCharArray();
            output(change(chars, n));
        }
    }

    private static char[] change(char[] chars, int n) {
        int index = 0;
        while (index < n - 1) {
            if (chars[index] == '0' && chars[index + 1] == '0') {
                chars[index] = '1';
                chars[index + 1] = '0';
            } else if ((index > 0) && (chars[index] == '1') && (chars[index + 1] == '0') && (chars[index - 1] == '0')) {
                chars[index - 1] = '1';
                chars[index] = '0';
                chars[index + 1] = '1';
            }
            index++;
        }
        return chars;
    }

    private static void output(char[] chars) {
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
    }
}
//此题测试数据有问题，因为10换成01的目的就是为了让换后的0再和前面的0组合，把00换成10，适用于0+1*k+0的情况。