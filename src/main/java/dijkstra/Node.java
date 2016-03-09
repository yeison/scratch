package dijkstra;

import net.openhft.koloboke.collect.map.IntIntMap;
import net.openhft.koloboke.collect.map.hash.HashIntIntMaps;

public class Node implements Comparable<Node> {
    IntIntMap edges = HashIntIntMaps.newMutableMap();
    int greedyScore = 1_000_000;

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