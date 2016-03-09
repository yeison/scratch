package dijkstra;

import com.google.common.collect.MinMaxPriorityQueue;
import net.openhft.koloboke.collect.map.IntIntCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;

/**
 * Created by yeison on 3/8/16.
 */
public class DijkstraImpl {
    private static final Logger LOG = LoggerFactory.getLogger(DijkstraProblem.class);

    public static final int DEFAULT_SIZE = 200;

    private final PriorityQueue<Node> heap = new PriorityQueue<>(DEFAULT_SIZE);

    private final BitSet X = new BitSet(DEFAULT_SIZE);
    private final BitSet heapSet = new BitSet(DEFAULT_SIZE);
    private final ArrayList<Node> nodes;

    public DijkstraImpl(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }


    public int getShortestPath(Node a, Node b){

        // start with the first vertex in the set of known vertexes
        X.set(0);

        // explore edges of said vertex
        Node n = nodes.get(0);
        n.greedyScore = 0;
        edgeExplore(n);

        Node last = n;

        while( ! last.equals(b) ){
            /*
            *  At this point we should have all the crossing edges,
            *  along with their greedy path scores computed.  We
            *  should now query the heap for the lowest greedy score
            *  and add the corresponding vertex to the set of known
            *  edges and then perform the edge exploration on the newly
            *  added vertex.
            */

            Node next = heap.remove();

            X.set(next.index-1);

            edgeExplore(next);

            last = next;
        }

        return b.greedyScore;

    }


    /**
     * Computes potential greedy scores and adds crossing edges to the heap
     * @param node
     */
    private void edgeExplore(Node node){
        for(IntIntCursor vertexCursor = node.edges.cursor(); vertexCursor.moveNext(); ){

            int vertexIndex = vertexCursor.key()-1;

            // not a crossing edge if vertex is already in X, so skip
            if(X.get(vertexIndex)){
                continue;
            }

            Node n = nodes.get(vertexIndex);

            // compute potential new score by adding the edge length to node's greedy score
            int candidateScore = node.greedyScore + vertexCursor.value();

            // determine if a score update is warranted
            if(candidateScore < n.greedyScore){
                n.greedyScore = candidateScore;
            }

            // add to heap if not already present
            if(!heapSet.get(vertexIndex)){
                heap.add(n);
                heapSet.set(vertexIndex);
            }

        }
    }
}
