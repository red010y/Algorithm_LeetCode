package Array.TrappingRainWater42;

/**
 * 思路：
 * 核心思路：给每一列的柱子注水，每个的柱子的最大注水量
 *
 * 头和尾的柱子无法注水，其他的柱子注水时，当前柱子能注多少水取决于，他左边最大的柱子和右边最大的柱子的高度。
 * 如果当前柱子小于左右最大柱子时才可能注水
 * 最大注水=min(height[l_max],height[r_max])-height[current]
 */
public class Brute {

    public int trap(int[] height) {
        int sum=0;
        for (int current=1;current<height.length-1;current++){
            int l_max=current-1,r_max=current+1;
            for (int l=current-1;l>=0;l--){
                if (height[l]>height[l_max])l_max=l;
            }
            for (int r=current+1;r<height.length;r++){
                if (height[r]>height[r_max])r_max=r;
            }
            int min_bar = Math.min(height[l_max], height[r_max]);
            if (min_bar>height[current]) {
                sum += min_bar - height[current];
            }
        }
        return sum;
    }
}
