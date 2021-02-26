package Backtrack.NQueens51;

import java.util.*;

/**
 * 思路：
 * 从上往下
 * 核心思路：确定一个皇后的位置，列上，对角线上不能有其他皇后。右侧的对角线上的数，row-col的相同的。左侧对角线上的数，row+col相同。
 * 0,0  0,1 0,2 0,3
 * 1,0  1,1 1,2 1,3
 * 2,0  2,1 2,2 2,3
 * 主对角线（左）row+col相同。从对角线（右）row-col相同
 * 从对角线（右） 0,0 1,1 2,2
 * 主对角线（左） 0,2 1,1 2,0
 * 用栈存放符合要求的皇后的位置
 */
public class Backtrack {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        int[] arr=new int[n];
        HashSet<Integer> col_set = new HashSet<>();
        HashSet<Integer> master_set = new HashSet<>();
        HashSet<Integer> slave_set = new HashSet<>();
        //之前用一个set存放所有的主副对角线是不对的，每层的看，不能只是一味的存储
        //存储的是一条线
        recursive(col_set,slave_set,master_set,result,arr,n,0);
        return result;
    }

    private void recursive(HashSet<Integer> col_set, HashSet<Integer> slave_set, HashSet<Integer> master_set, ArrayList<List<String>> result, int[] arr, int n, int row) {

        if (row==n){
            ArrayList<String> list = new ArrayList<>();
            buildList(list,arr);
            result.add(list);
            return;
        }

        for (int col=0;col<n;col++){
            if (!col_set.contains(col)&&!master_set.contains(row+col)&&!slave_set.contains(row-col)){
                master_set.add(row+col);
                slave_set.add(row-col);
                col_set.add(col);
                arr[row]=col;
                recursive(col_set, slave_set, master_set, result, arr, n, row+1);
                master_set.remove(row+col);
                slave_set.remove(row-col);
                col_set.remove(col);
            }
        }
    }

    private void buildList(ArrayList<String> list, int[] arr) {
        for (int q:arr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (q==i)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
    }

}
