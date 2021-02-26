package TwodimensionalArry.NumberOfIslands200;

import java.util.LinkedList;

/**
 * 思路：
 * 当前位置表达：location=当前row*总column+当前column
 * 获取当前的row：row=location/总column
 * 获取当前的column：column=location%总column
 * 遍历二维数组出现1，岛屿数+1，入队
 * 修改1为0，bfs这个节点周围为1的节点，变为0，并入队
 */
public class BFS {
    public static int numIslands(char[][] grid) {
        int row=grid.length;
        if (row==0)return 0;
        int column=grid[0].length;
        int num=0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (grid[i][j]=='1'){
                    grid[i][j]='0';
                    num++;
                    int location=i*column+j;
                    queue.offer(location);
                    while (!queue.isEmpty()){
                        Integer poll = queue.poll();
                        int r = poll / column;
                        int c = poll % column;

                        while (r-1>=0&&grid[r-1][c]=='1'){
                            grid[r-1][c]='0';
                            queue.add((r-1)*column+c);
                        }

                        while (r+1<row&&grid[r+1][c]=='1'){
                            grid[r+1][c]='0';
                            queue.add((r+1)*column+c);
                        }

                        while (c-1>=0&&grid[r][c-1]=='1'){
                            grid[r][c-1]='0';
                            queue.add(r*column+c-1);
                        }

                        while (c+1<column&&grid[r][c+1]=='1'){
                            grid[r][c+1]='0';
                            queue.add(r*column+c+1);
                        }
                    }
                }
            }
        }
        return num;
    }
}
