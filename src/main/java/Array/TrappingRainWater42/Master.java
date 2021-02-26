package Array.TrappingRainWater42;

/**
 * 思路：
 * 从左到右，把每个柱子最多能注的水累加起来
 *
 * 记录左右柱子中最小的那个lower（地平线）
 * 比较当前地平线lower是否高于level（水库高度）
 * level-lower=当前柱子最大承载的水量
 */
public class Master {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lower = 0, level = 0, water = 0;
        while (r > l) {
            lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            water += level - lower;
        }
        return water;
    }
}
