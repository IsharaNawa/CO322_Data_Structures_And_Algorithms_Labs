//E17219
//K.G.I.S. Nawarathna

import java.util.ArrayList;     //importing array list library
import java.util.Arrays;        //importing array library

//obtaing reliability matrix using Depth First Search
class TC_DFS {

    private int vertices;
    private ArrayList<Integer>[] adjList;       //list of integer objects
    private int[][] tc;                         //transitive closure matrix

    public TC_DFS(int vertices) {               //constructor
        this.vertices = vertices;
        this.tc = new int[this.vertices][this.vertices];
        initAdjList();
    }

    //initializing the adjacency list with a 2d int array
    //set all the values to 0 as the defalult
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<>();
    }

    //connct u and v by placing v to the list connceted to u
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }


    public void transitiveClosure() {           //generating transitive closure of the graph
        for (int i = 0; i < vertices; i++)
            dfsUtil(i, i);

        //print all the lists
        for (int i = 0; i < vertices; i++)
            System.out.println(Arrays.toString(tc[i]));
    }


    
    private void dfsUtil(int s, int v) {        //recursive  
        if (s == v) {
            if (adjList[v].contains(v))
                tc[s][v] = 1;
        } else
            tc[s][v] = 1;
        for (int adj : adjList[v])
            if (tc[s][adj] == 0)
                dfsUtil(s, adj);        //recursive call for DFS traversal to generate Transitive closure
    }

    public static void main(String[] args) {
        TC_DFS g = new TC_DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("transitive closure matrix:");
        g.transitiveClosure();
    }
}