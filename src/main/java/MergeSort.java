import java.util.Arrays;

/**
 * Created by yeison on 2/18/16.
 */
public class MergeSort {

    public static void main(String[] args){

        int[] test = {5, 1, 3, 5, 1, 6, 1, 1, 1, 1};

        sort(test);

        System.out.println(Arrays.toString(test));

    }

    /**
     * Sort in place
     * @param a an array to sort in place
     */
    public static void sort(int[] a){
        int end = a.length;

        mergeSort(a, 0, end);

        // perform one final merge
        merge(a, 0, end);

    }

    public static void mergeSort(int[] a, int start, int end){

        int l = end - start;

        // base cases
        if(l == 2){
            if(a[start] > a[start+1]) {
                swap(a, start, start+1);
            }
            return;
        }else if(l == 1){
            return;
        }

        int mid = start + l/2;

        mergeSort(a, start, mid);

        mergeSort(a, mid, end);

        merge(a, start, end);

    }

    private static void merge(int[] a, int start, int end) {

        int l = end - start;
        int mid = start + l/2;

        int[] temp = new int[l];

        for (int i = start, j = mid, k = 0; (i < mid || j < end) && k < temp.length; k++) {

            if(i < mid && j < end) {
                if (a[i] < a[j]) {
                    temp[k] = a[i++];
                } else {
                    temp[k] = a[j++];
                }
            } else if(i == mid) {
                while (k < temp.length){
                    temp[k++] = a[j++];
                }
            } else if(j == end) {
                while (k < temp.length){
                    temp[k++] = a[i++];
                }
            }

        }

        //transfer
        for (int i = start, k = 0; k < temp.length;) {
            a[i++] = temp[k++];
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}