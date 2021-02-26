package Array.MostWater11;

public class DubboPointer_Master {
    public int maxArea(int[] height) {
        int max=0;
        for (int head=0,tail=height.length-1;head<tail;){
            int minBar=height[head]>height[tail]?height[tail--]:height[head++];
            max=Math.max(max,minBar*(tail-head+1));
        }
        return max;
    }
}
