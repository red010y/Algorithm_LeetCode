package TwodimensionalArry.NumberOfIslands200;

/**
 * 思路：
 * 数组中存放二维数组节点：i*column+j
 * rank优化构造并查集:构造中创建各自为营的数组，只要二维数组是1,数组角标和值都存放当前位置i*column+j,count++，rank都是0
 * 如果当前的范围内有1，根据rank进行union:找到当前节点和范围内节点的最终boss，并且让count--
 * getRoot：不断的向上找，直到角标和值一致，说明找到boss
 * getcount()一个岛屿就是一个集合，统计最后的集合个数
 * 构建并查集，找到1，找范围内为1的进行union
 */

/**
 * 思路：
 * 数组parent，rank中存放二维数组节点：i*column+j
 * 构建并查集，parent数组中为1的位置指向自己（一个岛屿），并记录岛屿数，rank记录深度
 * 遍历二维数组，遇到1，1变为0，看其周围数是否为1，是的话进行合并，如果两个位置的父节点不一样，说明原来孤立的岛屿要合并，count--
 * 看深度小的指向大的集合
 */
public class UseFindUnion_Rank {
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid==null)return 0;
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

    class FindUnion{
        int count;
        int rank[];
        int parent[];

        public FindUnion(char[][] grid){
            count=0;
            int row = grid.length;
            int column = grid[0].length;
            parent=new int[row*column];
            rank=new int[row*column];
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
            if (parent[i]!=i)parent[i]=find(parent[i]);
            return parent[i];
        }

        public void union(int current,int range){
            int currentRoot=find(current);
            int rangeRoot=find(range);
            if (currentRoot!=rangeRoot) {
                if (rank[currentRoot] > rank[rangeRoot]) {
                    parent[rangeRoot] = currentRoot;
                } else if (rank[currentRoot] < rank[rangeRoot]) {
                    parent[currentRoot] = rangeRoot;
                } else {
                    parent[currentRoot] = rangeRoot;
                    rank[rangeRoot] += 1;
                }
                count--;
            }
        }

        public int getCount(){
            return count;
        }
    }
}
