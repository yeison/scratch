/**
 * Created by yeison on 3/10/16.
 */
public class DFS {


    public static void dfsTraverse(Node[] G, int s){
        G[s].visited = true;
        System.out.println(G[s].name);

        for(int a : G[s].edges.stream().toArray()){
            if( ! G[a].visited ){
                dfsTraverse(G, a);
            }
        }
    }
}
