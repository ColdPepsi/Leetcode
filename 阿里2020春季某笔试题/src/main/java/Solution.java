/**
 * @author wubiao21 2020年07月10日 10:03:09
 */
public class Solution {
    //假设牌的张数放在cards数组中，cards[i]表示大小为i的牌，现在剩余几张。cards[0]空闲

    private int minTimes;//保存最优解

    public int playPoker(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        minTimes = Integer.MAX_VALUE;
        backTracking(cards, 0, 1);//从下表1开始
        return minTimes;
    }

    /**
     * 回溯，每张牌尝试4种出牌方式
     *
     * @param cards        牌剩余几张的数组
     * @param currentTimes 当前出牌几次了
     * @param index        目前在处理的下标
     */
    private void backTracking(int[] cards, int currentTimes, int index) {
        if (index >= cards.length) {
            minTimes = Math.min(currentTimes, minTimes);//记录最优结果
            return;
        }
        if (currentTimes > minTimes) {
            return;//剪枝
        }
        if (cards[index] == 0) {
            backTracking(cards, currentTimes, index + 1);
        }
        if (index + 2 < cards.length && cards[index] >= 2 && cards[index + 1] >= 2 && cards[index + 2] >= 2) {
            //出3连对子
            for (int i = 0; i < index + 3; i++) {
                cards[i] -= 2;
            }
            backTracking(cards, currentTimes + 1, index);//此处加1，遍历后面的，index不一定出完，所以还从index出发
            for (int i = 0; i < index + 3; i++) {//恢复现场
                cards[i] += 2;
            }
        }
        if (index + 4 < cards.length &&
                cards[index] >= 1 && cards[index + 1] >= 1 && cards[index + 2] >= 1 && cards[index + 3] >= 1 && cards[index + 4] >= 1) {
            //出5张顺子
            for (int i = 0; i < index + 5; i++) {
                cards[i]--;
            }
            backTracking(cards, currentTimes + 1, index);
            for (int i = 0; i < index + 5; i++) {//恢复现场
                cards[i]++;
            }
        }
        if (cards[index] >= 2) {
            //出对
            cards[index] -= 2;
            backTracking(cards, currentTimes + 1, index);
            cards[index] += 2;//恢复现场
        }
        //index出单张
        backTracking(cards, currentTimes + cards[index], index + 1);//index出完了，从index+1开始
    }
}