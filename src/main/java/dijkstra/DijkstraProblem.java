package dijkstra;

import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.io.LineReader;
import net.openhft.koloboke.collect.map.IntIntCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by yeison on 3/8/16.
 */
public class DijkstraProblem {

    private static final Logger LOG = LoggerFactory.getLogger(DijkstraProblem.class);

    public static final int DEFAULT_SIZE = 200;

    public static void main(String[] args){

        try {

            //ArrayList<Node> nodes = readFile("dijkstraData.txt");
            ArrayList<Node> nodes = readFile("dijkstraTestData.txt");

            DijkstraImpl di = new DijkstraImpl(nodes);

            for(Node n : nodes){
                di.getShortestPath(nodes.get(0), n);
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

            Node node = new Node(readEdgeNumber);

            for (int i = 1; i < edges.length; i++) {

                String[] tuple = edges[i].split(",");

                if(tuple.length == 2) {
                    // place edge details in edge map
                    node.edges.put(Integer.valueOf(tuple[0]), Integer.valueOf(tuple[1]));
                }

            }

            nodes.add(node);
        }

        return nodes;
    }

}