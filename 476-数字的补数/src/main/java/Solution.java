/**
 * @author WuBiao
 * @date 2020/3/30 16:26
 */
public class Solution {
    /**
     * @param num
     * @return int
     * @description 对于 00000101，要求补码可以将它与 00000111 进行异或操作。
     * 那么问题就转换为求掩码 00000111。
     * @author WuBiao
     * @date 2020/3/30 16:32
     */
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int mask = 1 << 30;
        while ((num & mask) == 0) {//找到num最高位为1的数
            mask >>= 1;
        }
        mask = (mask << 1) - 1;//mask变成与num位数相同 但是全是1的数
        return mask ^ num;
    }
}