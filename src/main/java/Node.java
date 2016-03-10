import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class Node implements Comparable<Node>{
    final BitSet edges = new BitSet();
    boolean visited = false;
    int name = -1;

    // the distance from an arbitrary source
    int distance = Integer.MAX_VALUE;

    @Override
    public int compareTo(Node o) {
        return name - o.name;
    }
}