import com.google.common.io.LineReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by yeison on 2/27/16.
 */
public class BFS {
    private static Random R = new Random();

    public static void main(String[] args) throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData5").toArray(new Node[0]);

        BFS.printBFSOrder(nodes, 0);    }

    /**
     * Starting from Node at index s find the node at index t
     */
    public static int getShortestPath(int s, int t, Node[] nodes){
        if(t == s) return 0;

        nodes[s].visited = true;
        nodes[s].distance = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(nodes[s]);

        while( ! q.isEmpty() ){
            Node n = q.poll();

            for(int v : n.edges.stream().toArray()){
                if(v == t) return n.distance + 1; // found t

                if( ! nodes[v].visited ){
                    nodes[v].distance = n.distance + 1;
                    nodes[v].visited = true;
                    q.add(nodes[v]);
                }
            }
        }

        return nodes[t].distance;
    }

    public static void printBFSOrder(Node[] G, int s){
        List<List<Node>> bfsList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        Node G_s = G[s];
        G_s.distance = 0;
        G_s.visited = true;
        q.add(G_s);
        getOrCreateList(0, bfsList).add(G_s);

        while(!q.isEmpty()){
            Node n = q.remove();

            for(int v : n.edges.stream().toArray()){
                Node G_v = G[v];
                if(!G_v.visited){
                    G_v.distance = n.distance + 1;
                    G_v.visited = true;
                    q.add(G_v);
                    getOrCreateList(G_v.distance, bfsList).add(G_v);
                }
            }
        }

        // completed graph traversal now sort and print
        for(List<Node> l : bfsList){
            Collections.sort(l);

            for(Node n : l){
                System.out.println(n.name);
            }
        }

    }

    private static List<Node> getOrCreateList(int i, List<List<Node>> bfsList) {
        List<Node> result = null;

        if(bfsList.size() > i){
            result = bfsList.get(i);
        }

        if(result == null){
            result = new ArrayList<>();
            bfsList.add(result);
        }

        return result;
    }

    /**
     * Randomly creates and undirected graph with maxNodes
     */
    private static Node[] randomGraphGenerator(int maxNodes){
        if(maxNodes < 1) return null;

        int numberOfNodes = 1 + R.nextInt(maxNodes);

        Node[] nodes = new Node[numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new Node();
            nodes[i].name = i;
        }

        // in the case where we only have one node
        if(numberOfNodes == 1) return nodes;

        /*
         * iterate through all nodes and randomly add edges
         * to the other nodes
         */
        for (int i = 0; i < numberOfNodes; i++) {
            int numberOfEdges = 1 + R.nextInt(numberOfNodes-1);

            for (int j = 0; j < numberOfEdges; j++) {
                int vertex = R.nextInt(numberOfNodes);
                if(vertex == i){j--; continue;} // skip self loops
                nodes[i].edges.set(vertex);
            }
        }

        return nodes;
    }

    public static ArrayList<Node> readFile(String filename) throws IOException {

        ArrayList<Node> nodes = new ArrayList<>();

        LineReader reader = new LineReader(new BufferedReader(new FileReader(filename)));

        String line = reader.readLine();

        for(int expectedEdgeNumber = 1; line != null; line = reader.readLine(), expectedEdgeNumber++){
            String[] edges = line.split("\\s");

            int readEdgeNumber = Integer.valueOf(edges[0]);

            if(expectedEdgeNumber != readEdgeNumber){
                System.out.println("The input is malformed.");
                System.exit(1);
            }

            Node node = new Node();

            node.name = readEdgeNumber;

            for (int i = 1; i < edges.length; i++) {
                // place edge details in edge set
                node.edges.set(Integer.valueOf(edges[i])-1);
            }

            nodes.add(node);
        }

        return nodes;
    }
}