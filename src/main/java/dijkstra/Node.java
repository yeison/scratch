package dijkstra;

import net.openhft.koloboke.collect.map.hash.HashIntIntMap;
import net.openhft.koloboke.collect.map.hash.HashIntIntMaps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node implements Comparable<Node> {
    Map<Integer, Integer> edges = HashIntIntMaps.newMutableMap();
    int pathScore = Integer.MAX_VALUE;

    @Override
    public int compareTo(Node o) {
        //TODO
        return 0;
    }
}