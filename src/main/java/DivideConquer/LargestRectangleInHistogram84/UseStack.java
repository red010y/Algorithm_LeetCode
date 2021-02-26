package DivideConquer.LargestRectangleInHistogram84;

import java.util.ArrayDeque;

/**
 * 思路：
 * 核心思路：
 * 确定每个柱子的左右边界，一旦确定就进行area计算（确定每个棒子最大可能的面积，知道了所有的柱子最大可能面积就能找到柱状图最大面积）
 * 不断的向前遍历数组，我们是一定可以知道的是每个棒子的左边界（左边的棒子已经遍历到），但是棒子的右边界无法确定（右边的棒子还未遍历到）。
 *
 * 栈能很好能实现这个思路
 * 栈中存放初始值-1（方便第一个棒子计算面积），栈中存放的是数组的下标
 * 遍历数组
 * 如果当前值比栈中元素大就入栈（这样当前柱子的左边界就是他们在栈中的下一个元素）
 * 如果当前值比栈中元素小就把栈中元素都出栈！！出栈元素的左右边界相当于确定了（左边界是栈中的下一个元素，右边界就是这个比他小的元素），计算area和max进行比较。之后入栈当前值
 * 遍历完后，清空栈，计算面积：这个时候剩余元素的右边界都是heights.length，左边界依旧是栈中下一个元素
 */
public class UseStack {


    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max=0;
        for (int i=0;i<heights.length;i++){
            while (stack.peek()!=-1&&heights[i]<heights[stack.peek()]){
                int bar_heigh=heights[stack.pop()];
                int area=bar_heigh*(i-stack.peek()-1);
                max=area>max?area:max;
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            int bar_heigh = heights[stack.pop()];
            int area=bar_heigh*(heights.length-stack.peek()-1);
            max=area>max?area:max;
        }
        return max;
    }

}
