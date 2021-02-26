package Heap.UglyNum49;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 思路：
 * 丑数：从1开始，当前的数*235，插入堆中，之后删除堆顶元素加入到result中
 * 在用堆顶元素*235,将新的丑数加入到堆中，并用set集合去重。循环这个过程
 */
public class UseHeap {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        long[] res = new long[n + 1];
        int[] primes={2,3,5};
        HashSet<Long> set = new HashSet<>();
        int index=1;
        while (!heap.isEmpty()) {
            Long remove = heap.remove();
            for (int prime : primes) {
                long uglyNum = remove * prime;
                if (!set.contains(uglyNum)) {
                    set.add(uglyNum);
                    heap.add(uglyNum);
                }
            }
            res[index++] = remove;
            if (index == res.length) return (int)res[n];
        }
        return (int)res[n];
    }
}
