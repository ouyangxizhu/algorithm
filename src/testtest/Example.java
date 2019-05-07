package testtest;

/**
 * Created by ouyangxizhu on 2019/4/12.
 */
public class Example {
    public static void greet(){
        System.out.println("hello");
    }
    public static void main(String[] args){
        Example x = null;
        x.greet();
        ((Example)x).greet();
        ((Example)null).greet();



    }

}
