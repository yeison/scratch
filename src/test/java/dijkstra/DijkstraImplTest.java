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

    @Test
    public void testGetSimplePath3() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData4Node.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(3));

        Assert.assertEquals(9, result);
    }

    @Test
    public void testGetSimplePath4() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData5Node.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(4));

        Assert.assertEquals(10, result);
    }

    @Test
    public void testGetSimplePath5() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData5Node2.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(4));

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetSimplePath6() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData5Node3.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(4));

        Assert.assertEquals(2, result);

        result = di.getShortestPath(nodes.get(0), nodes.get(1));

        Assert.assertEquals(3, result);

        result = di.getShortestPath(nodes.get(0), nodes.get(2));

        Assert.assertEquals(2, result);

    }

    @Test
    public void testGetNoPath() throws IOException {
        ArrayList<Node> nodes = DijkstraProblem.readFile("dijkstraTestData6Node.txt");

        DijkstraImpl di = new DijkstraImpl(nodes);

        int result = di.getShortestPath(nodes.get(0), nodes.get(5));

        Assert.assertEquals(Node.NO_PATH, result);
    }

}
