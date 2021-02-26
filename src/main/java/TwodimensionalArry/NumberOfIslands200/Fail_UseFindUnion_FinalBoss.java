package TwodimensionalArry.NumberOfIslands200;

public class Fail_UseFindUnion_FinalBoss {
    public static int numIslands(char[][] grid) {
        int row=grid.length;
        int column=grid[0].length;
        FindUnion findUnion = new FindUnion(grid);
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (grid[i][j] == '1') {
                    grid[i][j]='0';
                    if (i-1>=0&&grid[i-1][j]=='1'){
                        findUnion.union(i*column+j,(i-1)*column+j);
                    }
                    if (i+1<row&&grid[i+1][j]=='1'){
                        findUnion.union(i*column+j,(i+1)*column+j);
                    }
                    if (j-1>=0&&grid[i][j-1]=='1'){
                        findUnion.union(i*column+j,i*column+j-1);
                    }
                    if (j+1<column&&grid[i][j+1]=='1'){
                        findUnion.union(i*column+j,i*column+j+1);
                    }
                }
            }
        }
        return findUnion.getCount();
    }

    static class FindUnion{
        int parent[];
        int count=0;

        public FindUnion(char grid[][]){
            int row = grid.length;
            int column = grid[0].length;
            parent=new int[row*column];
            for (int i=0;i<row;i++){
                for (int j=0;j<column;j++){
                    if (grid[i][j]=='1') {
                        count++;
                        parent[i * column + j] = i * column + j;
                    }
                }
            }
        }

        public int find(int i){
            int root=i;
            while (parent[root]!=root) {
                root=parent[root];
            }
            while (parent[i]!=i){
                int tmp=parent[i];
                parent[i]=root;
                i=tmp;
            }
            return root;
        }

        public void union(int current,int range){
            int currentRoot = find(current);
            int rangeRoot = find(range);
            parent[currentRoot] = rangeRoot;
            count--;
        }

        public int getCount(){
            return count;
        }
    }
}
