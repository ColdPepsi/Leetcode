import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/28 22:14
 */
public class Solution2 {
    public int[] beautifulArray(int N) {
        if (N == 1) {
            return new int[]{1};
        }
        if (N == 2) {
            return new int[]{1, 2};
        }
        if (N == 3) {
            return new int[]{1, 3, 2};
        }
        if (N == 4) {
            return new int[]{1, 3, 2, 4};
        }
        List<Integer> arr = new ArrayList<Integer>(2 * N);
        arr.addAll(Arrays.asList(1, 3, 2, 4));
        while (arr.size() < N) {
            int size = arr.size();
            for (int i = 0; i < size; i++) {
                arr.set(i, arr.get(i) * 2 - 1);//先扩成奇数
                arr.add(arr.get(i) + 1);//把偶数漂亮数组加在后面
            }
        }
        int[] res = new int[N];
        int index = 0;
        for (Integer integer : arr) {
            if (integer <= N) {
                res[index++] = integer;
            }
        }
        return res;
    }
}
//漂亮数组的性质：
//（1）A是一个漂亮数组，如果对A中所有元素添加一个常数，那么Ａ还是一个漂亮数组。
//（2）A是一个漂亮数组，如果对A中所有元素乘以一个常数，那么A还是一个漂亮数组。
//（3）A是一个漂亮数组，如果删除一些A中所有元素，那么A还是一个漂亮数组。
//（4) A是一个奇数构成的漂亮数组，B是一个偶数构成的漂亮数组，那么A+B也是一个漂亮数组

//构造漂亮数组：
//对{1~m}中所有的数乘以2-1，构成一个奇数漂亮数组A。如{1,3,2,4},可以得到{1,5,3,7}
//对{1~m}中所有的数乘以2,构成一个偶数漂亮数组B,如{1,3,2,4}, 可以得到{2,6,4,8}
//A+B构成了{1~2m}的漂亮数组。{1,5,3,7}+{2,6,4,8}={1,5,3,7,2,6,4,8}
//从中删除不要的数字即可。