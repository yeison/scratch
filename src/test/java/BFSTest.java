import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by yeison on 3/9/16.
 */
public class BFSTest {

    @Test
    public void testFindSelf() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 0, nodes);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetShortestPath1() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 1, nodes);

        Assert.assertEquals(1, result);
    }


    @Test
    public void testGetShortestPath2() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 2, nodes);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetShortestPath3() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData2").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 1, nodes);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetShortestPath4() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData2").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 2, nodes);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetShortestPath5() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData2").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 3, nodes);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetShortestPath6() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 1, nodes);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetShortestPath7() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 2, nodes);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetShortestPath8() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 4, nodes);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetShortestPath9() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 5, nodes);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetShortestPath10() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 3, nodes);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetShortestPath11() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData3").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 6, nodes);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetShortestPath12() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData4").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 7, nodes);

        Assert.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testGetShortestPath13() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData4").toArray(new Node[0]);

        int result = BFS.getShortestPath(0, 8, nodes);

        Assert.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testPrintBFSOrder() throws IOException {
        Node[] nodes = BFS.readFile("BFSTestData5").toArray(new Node[0]);

        BFS.printBFSOrder(nodes, 0);
    }
}
