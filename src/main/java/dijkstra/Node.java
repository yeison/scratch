package dijkstra;

import net.openhft.koloboke.collect.map.IntIntMap;
import net.openhft.koloboke.collect.map.hash.HashIntIntMaps;

public class Node implements Comparable<Node> {
    public static final int NO_PATH = 1_000_000;

    IntIntMap edges = HashIntIntMaps.newMutableMap();
    int greedyScore = NO_PATH;

    public final int index;

    public Node(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return greedyScore - o.greedyScore;
    }

    /**
     * Returns true if this node is adjacent to the node i
     *
     * @param i - the value of the node that is being checked for adjacency
     * @return
     */
    public boolean isAdjacentTo(int i){
        return edges.get(i) != edges.defaultValue();
    }
}