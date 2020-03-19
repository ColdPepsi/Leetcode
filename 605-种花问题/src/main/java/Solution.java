/**
 * @author WuBiao
 * @date 2020/3/19 21:36
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;//计算一共能种多少朵花
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {//flowerbed[i]没种花进行下面操作
                int pre = (i == 0 ? 0 : flowerbed[i - 1]);//记录flowerbed[i-1]的状态
                int next = (i == flowerbed.length - 1 ? 0 : flowerbed[i + 1]);//记录flowerbed[i+1]的状态
                if (pre == 0 && next == 0) {//如果左右都没种花
                    count++;
                    flowerbed[i] = 1;
                }
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}