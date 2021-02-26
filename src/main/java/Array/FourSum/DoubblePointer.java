package Array.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：
 * 先将数组进行排序
 * 先确定所有可能的2数之和
 * 之后进行夹逼找，4数和大于target，移动r，反之亦然。直到等于target
 */
public class DoubblePointer {
    public static void main(String[] args) {
        int arr[]={1, 0, -1, 0, -2, 2,6,-9,-6};
        fourSum(arr,0);
        System.out.println();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        int length=nums.length;
        for (int i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int min=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min>target){
                break;
            }
            int max=nums[i]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max<target){
                continue;
            }
            for (int j=i+1;j<length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l=j+1,r=length-1;
                int min2 = nums[i] + nums[j] + nums[l] + nums[l+1];
                if(min2>target){
                    continue;
                }
                int max2=nums[i] + nums[j] + nums[r] + nums[r-1];
                if(max2<target){
                    continue;
                }
                while (r>l){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum==target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        l++;
                        while(l<r&&nums[l]==nums[l-1]){
                            l++;
                        }
                        r--;
                        while(l<r&&i<r&&nums[r]==nums[r+1]){
                            r--;
                        }
                    }else if (sum>target){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        ArrayList<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i=0;i<nums.length-3;i++){
//            for (int j=i+1;j<nums.length-2;j++){
//                int l=j+1,r=nums.length-1;
//                while (r>l){
//                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
//                    if (sum==target){
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[l]);
//                        list.add(nums[r]);
//                        result.add(list);
//                        l++;
//                    }else if (sum>target){
//                        r--;
//                    }else {
//                        l++;
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
