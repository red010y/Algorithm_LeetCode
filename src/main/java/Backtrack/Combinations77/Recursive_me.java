package Backtrack.Combinations77;

import java.util.ArrayList;
import java.util.List;
/**
 * 这个思路和题解回溯的思路是一样的，不过题解的思路更精简，比我的好。这就是差距，还要好好学！！！
 * 看问题的本质，这个题我做到了。但是题解看的比我更本质，这个思维的训练要继续，加油！！！
 *
 * 思路：
 * 介于题目要求，[1,2]和[2,1]属于同一个组合。哪我们就可以让1-n的数只和其后的数进行组合
 * 递归的添加元素
 * 如果当前的list长度==k就在结果集中加入list
 * 只要当前i不等于n就进行循环
 * i++
 * 之后进行递归
 * 每次递归结束（获取了当前数的所有组合，进行下一个数），我们需要删除掉当前数，也就是list最后添加的元素
 * （保证新元素进来，list是在当前基础上进行的，比如k=3的情况下：1,2,x。x可以不断的变化）
 *
 * 特殊情况：
 * k==0,直接返回
 * k==1,在递归函数中第一行进行add操作
 *
 * 卡死在了，怎么控制传入新的list
 * 解决result.add(new ArrayList<>(list));
 */
public class Recursive_me {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (k==0)return result;
        for (int i=1;i<=n-k+1;i++){
            ArrayList<Integer> list = new ArrayList<>();
            recursive(result,i,n,k,list);
        }
        return result;
    }

    private void recursive(ArrayList<List<Integer>> result, int i, int n,int k, ArrayList<Integer> list) {
        list.add(i);
        if (list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        while (i!=n){
            i++;
            recursive(result,i,n,k,list);
            list.remove(list.size()-1);
        }
    }
}
