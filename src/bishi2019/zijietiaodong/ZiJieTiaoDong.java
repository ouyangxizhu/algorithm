package bishi2019.zijietiaodong;

import java.util.Scanner;
/**https://blog.csdn.net/XH413235699/article/details/88595458
 * 找钱问题，共1024，64，16，4，1几种面值。因为1，4，16，64这几种面值都可以由小于他们的面值凑出来，所以直接贪心的选最大的面值就好。
 * @author ouyangxizhu
 *
 */
public class ZiJieTiaoDong implements Runnable{

    private final int mod = 1000000007, max = 200005;
    private final int [] arr = {64, 16, 4, 1};

    public static void main(String[] args) {
        new Thread(null, new ZiJieTiaoDong(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve(){
        Scanner cin = new Scanner(System.in);
        int N = 1024-cin.nextInt(), ans = 0;
        for(int i=0; i<4; i++){
            ans += N/arr[i];
            N %= arr[i];
        }
        System.out.println(ans);
    }
}

