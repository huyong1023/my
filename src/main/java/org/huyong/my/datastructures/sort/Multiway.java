/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/2/23 9:55
 */
package org.huyong.my.datastructures.sort;

public class Multiway {

    public static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);

        for (int i = 0; i < N; i++)
            if (! streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        while ( pq.isEmpty())
        {
            StdOut.println(pq.min());
            int i = pq.delMin();

            if (! streams[i].isEmpty())
                pq.insert(i. steams[i].readString())
        }
    }

}
