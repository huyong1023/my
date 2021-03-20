/**
 * 优先队列
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/2/22 15:25
 */
package org.huyong.my.datastructures.sort;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN];
    }


    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2 *k;
            if (j < N && less(j, j + 1))
                j ++;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k){
        while (k > 1 && less(k/2, k) ){
            exch(k/2, k);
            k = k/2;
        }
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }


}
