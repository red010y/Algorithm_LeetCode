package Array.TrappingRainWater42;
/**
 * 思路：
 * 核心思路：
 * 找到每个坑，计算面积和
 * 每个坑都有左右边界，我们要确定好边界
 *
 * 只要右边界没走到数组的末尾就一直循环
 * 找左边界：记录左边界，只要下一个值比左边界小，就确定了左边界。否则，更新左边界为下一个值
 * 之后向后找右边界：
 * 记录最大的棒子
 * 大于等于左边界就是右边界，否则一直向前找
 * 如果找到数组末尾都没找到大于等于左边界的值，就把最大的棒子作为右边界
 * 找到左右边界后计算坑的面积：min(height[l],hei[r])*(r-l-1)-夹在左右边界中的各个柱子的高度
 */
public class Brute_Border {
    public int trap(int[] height) {
        int sum=0,bar_sum=0,l=0,r = 0;
        while (r<height.length-1) {
            for (int i = l+1; i < height.length; i++) {
                if (i==0||height[i] >= height[i - 1]) l = i;
                else break;
            }
            int  max_bar=l+1;
            for (int i = l + 1; i < height.length; i++) {
                //如果当前棒子大于max_bar就记录
                max_bar=height[max_bar]>height[i]?max_bar:i;
                if (height[i] >= height[l]) {
                    r = i;
                    break;
                }
            }
            if (max_bar>=height.length)break;
            //如果没有找到大于等于左棒子的，就把max_bar作为右棒子
            if (r<=l) {
                r=max_bar;
            }
            int area = Math.min(height[l], height[r]) * (r - l - 1);
            for (int j = l + 1; j < r; j++) {
                bar_sum += height[j];
            }
            sum += area - bar_sum;
            l = r;
            bar_sum = 0;
        }
        return sum;
    }
}
