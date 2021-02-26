package DivideConquer.LargestRectangleInHistogram84;

/**
 * 思路：
 * 暴力，双层for
 * 记录最大面积max,和最小柱子的高度
 * 不断向前遍历，找到每个棒子所在范围内的最小值，更新min和area
 *
 * 注意：1根柱子也可以计算面积
 */
public class Brute_Tuning {

    public int largestRectangleArea(int[] heights) {
        int max=0,minHeight;
        for (int i=0;i<heights.length;i++){
            minHeight=heights[i];
            for (int j=i;j<heights.length;j++){
                minHeight=minHeight>heights[j]?heights[j]:minHeight;
                int area = minHeight * (j - i + 1);
                max=max>area?max:area;
            }
        }
        return max;
    }
}
