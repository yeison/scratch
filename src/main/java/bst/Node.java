package bst;

/**
 * Created by yeison on 3/10/16.
 */
public class Node implements Comparable<Node>{
    Node left;
    Node right;

    final int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
