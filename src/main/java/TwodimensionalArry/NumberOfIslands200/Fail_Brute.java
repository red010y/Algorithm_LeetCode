package TwodimensionalArry.NumberOfIslands200;

/**
 * 思路：
 * 记录岛屿数
 * 遍历二维数组，如果是第一个元素或者前一列是0的情况下就进行判断
 * 如果值是1,并且上下左右都==0或者超出二维数组就说明有一个岛屿
 *
 */
public class Fail_Brute {
    public static void main(String[] args) {
        numIslands(initMatrix());
    }
    public static int numIslands(char[][] grid) {
        int num=0;
        int row=grid.length;
        int column=grid[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if(i==0&&j==0&&grid[i][j]=='1') {
                    num++;
                    continue;
                }
                if (grid[i][j]=='1'&&(i-1<0||grid[i-1][j]=='0')&&(i+1==row||grid[i+1][j]=='0')
                        &&(j-1<0||grid[i][j-1]=='0')&&(j+1==column||grid[i][j+1]=='0')){
                    num++;
                }
            }
        }
        return num;
    }
    //[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
    private static char[][] initMatrix() {
        char[][] matrix = new char[4][5];
        matrix[0][0]='1';
        matrix[0][1]='1';
        matrix[0][2]='1';
        matrix[0][3]='1';
        matrix[0][4]='0';

        matrix[1][0]='1';
        matrix[1][1]='1';
        matrix[1][2]='0';
        matrix[1][3]='1';
        matrix[1][4]='0';

        matrix[2][0]='1';
        matrix[2][1]='1';
        matrix[2][2]='0';
        matrix[2][3]='0';
        matrix[2][4]='0';

        matrix[3][0]='0';
        matrix[3][1]='0';
        matrix[3][2]='0';
        matrix[3][3]='0';
        matrix[3][4]='0';
        return matrix;
    }
}
