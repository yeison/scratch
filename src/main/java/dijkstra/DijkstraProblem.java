package dijkstra;

import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.io.LineReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yeison on 3/8/16.
 */
public class DijkstraProblem {

    private static final Logger LOG = LoggerFactory.getLogger(DijkstraProblem.class);

    public static final int DEFAULT_SIZE = 200;
    public static final int NO_PATH = 1_000_000;

    private static MinMaxPriorityQueue<Node> heap = MinMaxPriorityQueue.expectedSize(DEFAULT_SIZE).create();

    public static void main(String[] args){

        ArrayList<Node> nodes = null;

        try {

            nodes = readFile("dijkstraData.txt");

            // initialize
            BitSet explored = new BitSet(DEFAULT_SIZE);

            nodes.get(0).pathScore = 0;

            for (int i = 0; i < nodes.size(); i++) {
                // if i has not been explored perform dijkstra's sssp on i
                if( ! explored.get(i) ){
                    Node n = nodes.get(i);



                    explored.set(i);
                }
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }

    public static ArrayList<Node> readFile(String filename) throws IOException {

        ArrayList<Node> nodes = new ArrayList<>(DEFAULT_SIZE);

        LineReader reader = new LineReader(new BufferedReader(new FileReader(filename)));

        String line = reader.readLine();

        for(int expectedEdgeNumber = 1; line != null; line = reader.readLine(), expectedEdgeNumber++){
            String[] edges = line.split("\\s");

            int readEdgeNumber = Integer.valueOf(edges[0]);

            if(expectedEdgeNumber != readEdgeNumber){
                LOG.error("The input is malformed.");
                System.exit(1);
            }

            Node node = new Node();

            for (int i = 1; i < edges.length; i++) {

                String[] tuple = edges[i].split(",");

                // place edge details in edge map
                node.edges.put(Integer.valueOf(tuple[0]), Integer.valueOf(tuple[1]));

            }

            nodes.add(node);
        }

        return nodes;
    }

}