package Backtrack.NQueens51;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 从下往上
 * 回溯，一行行确定
 * 用一个数组去存，数组索引是当前行，value是值所的在列的角标
 * 当前行的值确定前，先确定前面的所有行的 上，左上角，右上角查看是否有值
 * 用栈存放每行的Q的位置，每行都满足的时候从栈中还原n皇后
 */
public class Backtrack_Optimations {
    public static void main(String[] args) {
        new Backtrack_Optimations().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        int[] arr=new int[n];
        recursive3(result,arr,0);
        return result;
    }

    private void recursive3(ArrayList<List<String>> result, int[] arr, int lattice) {
        if (lattice==arr.length){
            ArrayList<String> list = new ArrayList<>();
            buildList(list,arr);
            result.add(list);
            return;
        }
        for (int column=0;column<arr.length;column++){
            boolean put_Q = isOK( column, arr,lattice);
            if (put_Q){
                arr[lattice]=column;
                recursive3(result, arr, lattice+1);
            }
        }
    }

    private boolean isOK(int col, int[] arr, int lattice) {

        for (int i=lattice-1;i>=0;i--){
            if (arr[i]==col)return false;
            if (arr[i]==col-(lattice-i))return false;
            if (arr[i]==col+(lattice-i))return false;
        }
        return true;
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

    //错的太傻了，不能把这些都存起来。是一层判断一次！！！
//    private boolean isOK(int col, int[] arr, int lattice) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i=lattice;i>=0;i--){
//            set.add(col+(lattice-i));
//            set.add(col-(lattice-i));
//        }
//        for (int i=0;i<lattice;i++){
//            if (set.contains(arr[i]))return false;
//        }
//        return true;
//    }

//    private boolean isOK( int column, int[] arr,int row) {
//        int leftup=column-1,rightup=column+1;
//        //遍历前面所有的Queen位置
//        for (int i=row-1;i>=0;i--){
//            //前面的位置等于当前列说明这个位置已经放下Queen
//            if (arr[i]==column) return false;
//            //左上
//            if (leftup>=0){
//                if (arr[i]==leftup)return false;
//            }
//            //右上
//            if (rightup<=arr.length-1){
//                if (arr[i]==rightup)return false;
//            }
//            //沿着左上，右上往上找
//            leftup--;
//            rightup++;
//        }
//        return true;
//    }
}
