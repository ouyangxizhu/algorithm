package zijietiaodongmianshi;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ouyangxizhu on 2019/3/30.
 */
public class Zijietiaozong {
    public static Set<String> set = new HashSet<>();
    public static void main(String[] args){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        dfs(list, 0, "");
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + ", ");
        }

    }

    private static void dfs(ArrayList<Character> list, int index, String str) {
        set.add(str);
        if (index < 0 || index >= list.size()){
            return;
        }
        String s = list.get(index) + "";
        dfs(list, index + 1, str);
        dfs(list, index + 1, str + s);

    }
}
