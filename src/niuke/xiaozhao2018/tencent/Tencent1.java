package niuke.xiaozhao2018.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 小Q十分富有，拥有非常多的硬币，小Q拥有的硬币是有规律的，对于所有的非负整数K，小Q恰好各有两个面值为2^K的硬币，
 所以小Q拥有的硬币就是1,1,2,2,4,4,8,8,…。
 小Q有一天去商店购买东西需要支付n元钱，
 小Q想知道有多少种方案从他拥有的硬币中选取一些拼凑起来恰好是n元（如果两种方案某个面值的硬币选取的个数不一样就考虑为不一样的方案）。

 输入描述:
 输入包括一个整数n(1≤n≤10^18)，表示小Q需要支付多少钱。注意n的范围。
 输出描述:
 输出一个整数，表示小Q可以拼凑出n元钱放的方案数。
 示例1
 输入

 复制
 6
 输出

 复制
 3
 * Created by ouyangxizhu on 2019/4/5.
 */
public class Tencent1 {
    /**
     *
     n如果是奇数，说明必须只用一个1块钱,剩下只能用2 4 8,那么问题转移成了状态转移f(n) = f(n>>1),
     此时2,4,8可以看做1,2,4,两者问题等价
     如果n是偶数，那么可以分为两种情况，使用两个1块钱，或者不使用1块钱；两个一块钱的话,右移一位，需要减1
     如果不使用的话还是右移一位。后面的问题也与1块钱无关，递归。再用一个map存储中间结果，解决重复性问题。
     f(n) = f(n>>1) + f((n>>1) -1)
     * @param args
     */
    private static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        map.put(0L, 1L);
        map.put(1L, 1L);

        long n = sc.nextLong();
        System.out.println(cal(n));
    }

    private static long cal(long n) {
        if (map.containsKey(n))
            return map.get(n);
        long result1 = cal(n >> 1);
        map.put(n >> 1, result1);
        long result;
        if((n & 1) == 1)
            result = result1;
        else{
            long result2 = cal((n >> 1) - 1);
            map.put((n >> 1) - 1, result2);
            result = result1 + result2;
        }
        map.put(n, result);
        return result;

    }

}
