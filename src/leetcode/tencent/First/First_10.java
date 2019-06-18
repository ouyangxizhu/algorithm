package First;

public class First_10 {
	public int maxArea(int[] height) {
		int max = 0;//存放最大值
		int newMax=0;//存放高度
		for (int i = 0; i < height.length-1; i++) {
			for (int j = i; j < height.length; j++) {
				newMax = Math.min(height[i],height[j])*(j-i);
				if (newMax>max) {
					max = newMax;
				}
			}
		}
        return max;
    }

}
