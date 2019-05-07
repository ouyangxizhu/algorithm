package bishi2019.Ali;

import java.util.Scanner;

/**
 * 第二题，就是多线程打印，
 * 比如两个线程打印ABABABAB…三个线程打印ABCABCABC…四个线程打印ABCDABCD…等等
 * Created by ouyangxizhu on 2019/4/9.
 */
public class Ali1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        for (int i = 0; i < n; i++) {
            new Thread(new PrintRunnable(i, n)).start();
        }
    }
}

class PrintRunnable implements Runnable{

    private int index;
    private int n;
    private static int count = 0;
    private static final Object lock = new Object();

    PrintRunnable(int index, int n){
        this.index = index;
        this.n = n;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if(count % n == index){
                    System.out.print((char)('A' + index));
                    //System.out.flush();
                    count++;
                }
            }
        }
    }
}
