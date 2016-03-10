package bst;

/**
 * Created by yeison on 3/10/16.
 */
public class BST {

    public static void main(String[] args){
        Node[] T = new Node[10];

        for (int i = 0; i < T.length; i++) {
            T[i] = new Node(i);
        }

        Node root = createBSTFromSortedArray(T, 0, T.length-1);

        System.out.println(root);
    }


    public static Node createBSTFromSortedArray(Node[] T, int L, int R){

        int diff = R-L;

        // no nodes
        if(diff < 0) return null;

        // leaf node
        if(diff == 0) return T[R];

        int range = diff + 1;

        int m = L + range/2;

        Node root = T[m];

        root.left = createBSTFromSortedArray(T, L, m-1);
        root.right = createBSTFromSortedArray(T, m+1, R);

        return root;

    }

}
