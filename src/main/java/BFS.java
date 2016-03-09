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

    public static void main(String[] args){
        //getShortestPath(0, 3);
    }

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
                    q.add(nodes[v]);
                }
            }
        }

        return nodes[t].distance;
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