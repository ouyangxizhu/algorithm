package leetcode.fentangguo;

public class Leetcode_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] tempArr = new int[num_people];
        int roundNum = 0;
        while(candies > 0){
            for(int i = 0; i < num_people; i++) {
                int deltaNum = num_people*roundNum + i+1;
                if (candies <= deltaNum)
                {
                    deltaNum = candies;
                }

                tempArr[i] += deltaNum;
                candies -= deltaNum;
                if (candies <= 0)
                {
                    break;
                }

            }
            roundNum ++;
        }
        return tempArr;
    }

}
