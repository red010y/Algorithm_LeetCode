package Array.TrappingRainWater42;

import java.util.ArrayDeque;
/**
 * 思路：
 * 核心思路：
 * 积水的面积 = 当前棒子和最低的那个棒子的高度差 * 他们的距离。
 *
 * 当前值小于栈顶元素就说明可能有积水产生，入栈
 * 如果当前值大于栈顶元素，说明积水产生，出栈当前栈顶元素
 * 比较栈顶和当前值的，找出小的那个min（积水产生的最大高度）。
 * 求出栈顶和当前元素的距离 *（min-出栈的元素值）
 */
public class UseStack {

    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum=0;
        for (int current=0;current<height.length;current++){
            while (!stack.isEmpty()&&height[current]>=height[stack.peek()]){
                Integer pop = stack.pop();
                if (stack.isEmpty())break;
                int distance=current-stack.peek()-1;
                int min=Math.min(height[stack.peek()],height[current]);
                int area=(min-height[pop])*distance;
                sum+=area;
            }
            stack.push(current);
        }
        return sum;
    }

}
