//E17219
//K.G.I.S. Nawarathna

import java.util.LinkedList;    //importing the linked list builin library

//class of the Bi partaite
class Bipartite {
    
    private final static int V = 4;                         //number of vertices

    public boolean isBipartite(int G[][], int src) {        //this function determines if a grpah is bi partite or not

        int colorArr[] = new int[V];                        //declaring a new array with the number of vertices for colors
        for (int i = 0; i < V; i++)
            colorArr[i] = -1;                               //assigning values to the color array as -1

        colorArr[src] = 1;                                  //assing 1 to the source node of the color array(assinging a color to the source node)
        
        //initializing a integer linked list.This works as a queue for vertices
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        //adding the source to the bipartite graph
        q.add(src); //add source to the queue

        //go until the queue is filled
        while (q.size() != 0) {
            int u = q.poll();               //remove the first node

            if (G[u][u] == 1)               //checking if there are any loops
                return false;               //in case of a loop in the node, that graph is not bi pratite

            for (int v = 0; v < V; v++)         //check for non coloured nodes

                if (G[u][v] == 1) {             //assuming there is an edge from u to v
                    if (colorArr[v] == -1) {            //if v is not colored assign a color
                        colorArr[v] = 1 - colorArr[u];
                        q.add(v);
                    } else if (colorArr[v] == colorArr[u])      //if it is colored and both nodes have the same color it is not bi partite
                        return false;       
                }
        }
        return true;                        //if above conditions are not met for all the vertices in the queue, the grpah must be bipartite
    }

   

    public static void main(String[] args) {
        int G1[][] = {  { 0, 1, 0, 1 }, 
                        { 1, 0, 1, 0 }, 
                        { 0, 1, 0, 1 }, 
                        { 1, 0, 1, 0 }  };

        Bipartite b1 = new Bipartite();
        if (b1.isBipartite(G1, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
        
        int G2[][] = {  { 0, 1, 0, 1 }, 
                        { 1, 0, 1, 0 }, 
                        { 0, 1, 1, 1 }, 
                        { 1, 0, 1, 0 }  };
        Bipartite b2 = new Bipartite();
        if (b2.isBipartite(G2, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}