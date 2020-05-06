import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuBiao
 * @date 2020/4/21 21:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cards = new int[n][3];
        int count = 1;//抽卡次数
        int useCount = 0;//抽了几次牌了
        int money = 0;//金额
        for (int i = 0; i < n; i++) {
            cards[i][0] = scanner.nextInt();
            cards[i][1] = scanner.nextInt();
            if (cards[i][1] != 0) {//统计有几次抽牌机会
                useCount++;
                cards[i][2] = 1;//表示这张牌已经抽了;
                count += cards[i][1];
                money += cards[i][0];
            }
        }
        if (count >= n) {
            int max = 0;
            for (int[] card : cards) {
                max += card[0];
            }
            System.out.println(max);
        } else {
            Arrays.sort(cards, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });
            int leftCount = count - useCount;
            for (int i = cards.length - 1; leftCount > 0 && i > 0; i--) {
                if (cards[i][2] == 0) {//如果这张牌还没抽
                    money += cards[i][0];
                    leftCount--;
                }
            }
            System.out.println(money);
        }
    }
}
