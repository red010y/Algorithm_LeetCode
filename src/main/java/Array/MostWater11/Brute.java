package Array.MostWater11;

/**
 * 思路：
 * 遍历所有可能
 * 记录max
 */
public class Brute {
    public int maxArea(int[] height) {
        int max=0;
        for (int i=0;i<height.length-1;i++){
            for (int j=i+1;j<height.length;j++){
                int num=(j-i)*Math.min(height[i],height[j]);
                if (num>max){
                    max=num;
                }
            }
        }
        return max;
    }
}
