package TwodimensionalArry.NumberOfIslands200;

/**
 * 思路：
 * 遍历二维数组，遇到1进行岛屿数累加
 * BFS当前的位置将其周围的值变为0，直到超出范围或者遇到0
 */
public class DFS {
    int row;
    int column;
    public int numIslands(char[][] grid) {
        int num=0;
        row =grid.length;
        if (row==0)return 0;
        column =grid[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i<0||j>=column||i>=row||j<0||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
