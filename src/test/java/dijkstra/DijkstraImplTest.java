package dijkstra;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class DijkstraImplTest {

    @Test
    public void testGetSimplePath1() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(1));

        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetSimplePath2() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(2));

        Assert.assertEquals(3, result);
    }

}
