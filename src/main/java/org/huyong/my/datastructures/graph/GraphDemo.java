package org.huyong.my.datastructures.graph;

/**
 * Created by yonghu on 2020/6/23.
 */
public class GraphDemo {
    public   static void main(String[] args) {


        int n = 8;  //结点的个数
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5"};

        //创建图对象
        GraphDemo graph = new GraphDemo(5);

        graph.min();

    }


    public GraphDemo(int n) {
        edges = new int[n][n];
        vertexList = new String[]{"1", "2", "3", "4", "5"};
        edges[0] = new int[]{1, 2, 3, 4, 5};
        edges[1] = new int[]{16, 17, 24, 23, 6};
        edges[2] = new int[]{15, 18, 25, 22, 7};
        edges[3] = new int[]{14, 19, 20, 21, 8};
        edges[4] = new int[]{13, 12, 11, 10, 9};
    }

    private String[] vertexList;
    private int[][] edges;

    private boolean[] isVisited;

    public void min(){
        isVisited = new boolean[vertexList.length];

        int flagi = 0;
        int minj = 0;
        int min = edges[flagi][minj];

        for (int i = 0; i < vertexList.length; i++){
            for (int j = 0; j < vertexList.length; j++){
                if(min > edges[i][j]){
                    min = edges[i][j];
                    flagi = i;
                    minj = j;
                }
            }
        }
        System.out.print(min +  " - ");
    }

}
