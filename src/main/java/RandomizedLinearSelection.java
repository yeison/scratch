import java.util.*;

/**
 * Created by yeison on 2/24/16.
 */
public class RandomizedLinearSelection {
    private static final Random RANDOM = new Random();

    public static void main(String[] args){
        int[] test = {6, 2, 7, 1, 7, 1, 22, 6, 1, 66, 1, 2, 6, 71, 8 ,9, 0, 0};

        int n = Integer.MAX_VALUE/1000;

        Set<Integer> values = new HashSet<Integer>(n);

        for (int i = 0; i < n; i++) {
            values.add( i);
        }


        ArrayList<Integer> valueList = new ArrayList<Integer>(values);

        values = null;

        System.gc();

        test = new int[n];

        for (int i = 0; i < valueList.size(); i++) {
            test[i] = valueList.get(i);
        }

        valueList = null;

        System.gc();

        //System.out.println(Arrays.toString(test));

        int ith = linearSelect(test, n/2, 0, test.length-1);

        System.out.println(n/2);
        System.out.println(ith);
    }

    /**
     * Select the ith element from the array a
     */
    public static int linearSelect(int[] a, int i, int start, int end){

        int n = end - start;

        if(n <= 1) return a[start];

        // randomized pivot selection
        int ran = start + RANDOM.nextInt(n);

        int pivot = partition(a, start, end, ran);

        if(i == pivot){
            return a[pivot];
        } else if(i < pivot) {
            return linearSelect(a, i, start, pivot-1);
        } else {
            return linearSelect(a, i, pivot+1, end);
        }

    }

    private static int partition(int[] a, int start, int end, int pivot) {
        swap(a, start, pivot);

        int i = start + 1;

        for (int j = start+1; j <= end; j++) {
            if(a[j] < a[start]){
                swap(a, i, j);
                i++;
            }
        }

        swap(a, start, i-1);

        return i-1;
    }

    private static void swap(int[] a, int i, int j) {
        if(i == j) return; // skip redundant swaps

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
