import java.util.*;

/**
 * Created by yeison on 2/27/16.
 */
public class BFS {
    private static Random R = new Random();

    static class Node {
        Set<Node> edges = new HashSet<Node>();
        boolean visited;
        int value = -1;
    }

    public static void main(String[] args){
        Node[] G = randomGraphGenerator(15);
        System.out.println(G);
    }

    public static void doBFS(Node n){

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
            nodes[i].value = i;
        }

        // in the case where we only have one node
        if(numberOfNodes == 1) return nodes;

        /* iterate through all nodes and randomly add edges
         * to the other nodes
         */
        for (int i = 0; i < numberOfNodes; i++) {
            int numberOfEdges = 1 + R.nextInt(numberOfNodes-1);

            for (int j = 0; j < numberOfEdges; j++) {
                int vertex = R.nextInt(numberOfNodes);
                if(vertex == i){j--; continue;} // skip self loops
                nodes[i].edges.add(nodes[vertex]);
            }
        }

        return nodes;
    }

}