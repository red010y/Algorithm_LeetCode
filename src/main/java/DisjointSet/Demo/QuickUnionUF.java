package DisjointSet.Demo;

/**
 * 并查集
 * 并：将两个集合合并
 * 查：找到一个集合的顶层boss（类似树形结构的根）
 */
public class QuickUnionUF {
    //数组中存放的是什么，角标和对应的值分别代表什么？
    //角标是我们要寻找的位置，对应的值指向boss
    private int[] roots;
    public QuickUnionUF(int N){
        roots=new int[N];
        for (int i=0;i<N;i++)roots[i]=i;
    }

    //目的：
    //寻找根节点
    //把所有小弟的指向都统一到顶层boss
    private int findRoot(int i){
        int root=i;
        while (roots[root]!=root)root=roots[root];
        //既然都找到了根节点，为什么还循环？
        //把当前节点指向变为顶层boss
        while (i!=roots[i]){
            int tmp=roots[i];
            roots[i]=root;
            //这是要干什么？
            //这是一个循环我们需要把每个手下的值都变为顶层boss，记录下一个小弟的位置
            i=tmp;
        }
        return root;
    }

    //判断两个节点是否在一个集合中
    private boolean connected(int p,int q){
        return findRoot(p)==findRoot(q);
    }

    //合并两个集合
    private void union(int p,int q){
        int proot=findRoot(p);
        int qroot=findRoot(q);
        //当前节点的顶层boss不在指向自身，指向另外一个顶层boss
        roots[proot]=qroot;
    }
}
