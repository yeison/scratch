import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by yeison on 3/9/16.
 */
public class BFSTest {

    @Test
    public void testSimpleGraph() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 2, nodes);

        Assert.assertEquals(2, result);
    }

}
