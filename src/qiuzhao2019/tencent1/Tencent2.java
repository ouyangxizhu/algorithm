package qiuzhao2019.tencent1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tencent2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Cunstmor> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Cunstmor(a, b));

        }
        Collections.sort(list,(o1, o2)->{
            if (o1.b - o1.a == o2.b - o2.a) {
                return o2.a - o1.a;
            } else {
                return (o1.b - o1.a) - (o2.b - o2.a);
            }
        });
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).a * i + list.get(i).b * (list.size() - i - 1);
        }


        System.out.println(res);

    }
    static class Cunstmor{
        public int a;
        public int b;

        public Cunstmor(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
