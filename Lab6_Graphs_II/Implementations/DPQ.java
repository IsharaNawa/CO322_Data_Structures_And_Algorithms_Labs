//E/17/219
//K.G.I.S. Nawarathna

import java.util.*;


public class DPQ {

    private int dist[];                 // stores the total distance between the node and the source(total cost in this case)
    private Set<Integer> settled;       // minimum distance(cost) is calculated for these nodes
    private PriorityQueue<Node> pq;     //priority queue for the nodes

    
    private int V;                      // Number of vertices

    List<List<Node>> adj;               // store the path as a list of lists

    // Constructor
    public DPQ(int V) {
        //initializing member variables
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    //This method implements the Dijkstas algorithm
    //THis method updates the totalDistance(total cost) for the adjacent nodes of a given node
    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;

        //at start, assigned distance as a max value
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // node to the priority queue
        pq.add(new Node(src, 0));

        // initially distance is 0
        dist[src] = 0;

        while (settled.size() != V) {

            //terminated when an empty queue
            if (pq.isEmpty())
                return;

            //remove the minimum distance(cost) node from the priority queue
            int u = pq.remove().node;

            //checking if the node is already in the setteled set
            if (settled.contains(u))
                continue;       //if it is continue to the next iteration

            //otherwise add to the settled list
            settled.add(u);

            //call the neighbours method
            e_Neighbours(u);
        }
    }

    // helper method for dijkstras algorithm
    // updates the total distance for the neighbours of a node
    private void e_Neighbours(int u) {

        int edgeDistance = -1;
        int newDistance = -1;

        // for all the nodes that are connected to the node u
        for (int i = 0; i < adj.get(u).size(); i++) {

            //getting the neighbour node of u
            Node v = adj.get(u).get(i);

            //Check if the node is already proceessed , if not...
            if (!settled.contains(v.node)) {

                //calculating the distance(cost) from the current node
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                //if the distance is lower than previous value, 
                //update that as the new distance by updating the array
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                //priority queue is updated with the current node
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    // driver for the class
    public static void main(String arg[]) {
        
        //create the adjacency list
        int V = 12;
        List<List<Node>> adj = new ArrayList<List<Node>>();

        // assigend the list for each and every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // initializing the graph
        adj.get(0).add(new Node(2, 1));
        adj.get(0).add(new Node(8, 5));

        adj.get(1).add(new Node(3, 6));

        adj.get(2).add(new Node(5, 10));
        adj.get(2).add(new Node(11, 2));
        adj.get(2).add(new Node(10, 7));
        adj.get(2).add(new Node(3, 11));

        adj.get(3).add(new Node(4, 9));
        adj.get(3).add(new Node(9, 4));

        adj.get(4).add(new Node(1, 10));
        adj.get(4).add(new Node(5, 4));
        adj.get(4).add(new Node(7, 1));

        adj.get(5).add(new Node(0, 3));
        adj.get(5).add(new Node(7, 7));

        adj.get(6).add(new Node(4, 2));

        adj.get(7).add(new Node(6, 12));

        adj.get(8).add(new Node(7, 7));

        adj.get(9).add(new Node(1, 12));

        adj.get(10).add(new Node(3, 5));

        // Calculating the single source the shortest path
        DPQ dpq0 = new DPQ(V);
        dpq0.dijkstra(adj, 0);

        DPQ dpq1 = new DPQ(V);
        dpq1.dijkstra(adj, 1);

        for (int i = 2; i < dpq0.dist.length; i++){
            if(dpq0.dist[i] <= dpq1.dist[i])
                System.out.println("Shortest distance from S0 to D"+i+" = "+dpq0.dist[i]);
            else
                System.out.println("Shortest distance from S1 to D"+i+" = "+dpq0.dist[i]);

        }
    }
}
