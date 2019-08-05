package leetcode.hot_100;

public class Hot_621 {
    /*
    解释一下这个公式怎么来的 (max - 1) * (n + 1) +maxCount：
    1.假设数组 ["A","A","A","B","B","C"]，n = 2，A的频率最高，记为count = 3，
    所以两个A之间必须间隔2个任务，才能满足题意并且是最短时间（两个A的间隔大于2的总时间必然不是最短），
    因此执行顺序为： A->X->X->A->X->X->A，这里的X表示除了A以外其他字母，或者是待命，
    不用关心具体是什么，反正用来填充两个A的间隔的。
    上面执行顺序的规律是： 有count - 1个A，其中每个A需要搭配n个X，再加上最后一个A，所以总时间为 (count - 1) * (n + 1) + 1；
    2.要注意可能会出现多个频率相同且都是最高的任务，比如 ["A","A","A","B","B","B","C","C"]，所以最后会剩下一个A和一个B，
    因此最后要加上频率最高的不同任务的个数 maxCount；
    3.公式算出的值可能会比数组的长度小，如["A","A","B","B"]，n = 0，此时要取数组的长度。
     */
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int max = 0;
        int maxCount = 0;
        int[] ch = new int[26];
        for(char t : tasks){
            int tmp = t - 'A';
            ch[tmp]++;
            if(ch[tmp] > max)
                max = ch[tmp];
        }
        for(int i : ch){
            if(i == max)
                maxCount++;
        }
        return Math.max((n + 1)* (max - 1) + maxCount,tasks.length);

    }
}
