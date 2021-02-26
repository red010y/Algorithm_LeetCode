package DivideConquer.LargestRectangleInHistogram84;

/**
 * 思路：
 * 核心思路：在最小值的左侧，和右侧才可能出现更大的面积
 *
 * 分治
 * 终止条件，start>end
 * 找到数组的最小值，求面积
 * 子问题：在左右侧在找最大面积
 */

public class DivideConquer {

    public int largestRectangleArea(int[] heights) {
        return divideConquer(0,heights.length-1,heights);
    }

    private int divideConquer(int start, int end, int[] heights) {
        //Terminator
        if (start>end){
            return 0;
        }
        //process current logic
        int min=start;
        for (int i=start;i<=end;i++){
            if (heights[i]<heights[min]){
                min=i;
            }
        }
        int area=heights[min]*(end-start+1);
        //drill down
        return Math.max(area,Math.max(divideConquer(start,min-1,heights),divideConquer(min+1,end,heights)));
        //restore store
    }


}
