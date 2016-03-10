import org.junit.Test;

import java.io.IOException;

/**
 * Created by yeison on 3/10/16.
 */
public class DFSTest {

    @Test
    public void testDfsTraverse() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData5").toArray(new Node[0]);

        DFS.dfsTraverse(nodes, 0);
    }

}
