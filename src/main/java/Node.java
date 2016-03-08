import java.util.HashSet;
import java.util.Set;

class Node {
    Set<Node> edges = new HashSet<>();
    boolean visited;
    int value = -1;
}