package set;

import com.google.common.math.IntMath;
import set.dimensions.type.Dimension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yeison on 3/13/16.
 */
public class Card {

    // This variable will reference the available dimensions (singleton)
    private static List<Dimension> dimensions = null;

    private static int valuesPerDimension;

    // store the values by dimension for this card
    private final int[] valuesByDimension;

    Card(int ... valuesByDimension) {
        this.valuesByDimension = valuesByDimension;
    }

    /**
     *  This function maps values for each dimension-value pair
     *  to the long space.  Due to overflow the mapping is not
     *  one-to-one, but it is onto
     */
    static int computeIntValue(int valueByDimension, int ordinal){

        return ordinal +  IntMath.pow(dimensions.size(), valueByDimension);

    }

    // cache hashCode value
    private int hashCode = -1;

    @Override
    public int hashCode() {
        if(hashCode == -1) {

            int result = 0;

            for (int i = 0; i < dimensions.size(); i++) {
                result += computeIntValue(valuesByDimension[i], i);
            }

            hashCode = result / dimensions.size();

            // we need to preserve -1 for not-initialized value
            if(hashCode == -1){
                hashCode++;
            }

        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if( ! (obj instanceof Card) ) return false;

        Card o = (Card) obj;

        // to test equality - compare the value for each dimension
        for (int i = 0; i < valuesByDimension.length; i++) {
            if(getValueByDimension(i) != o.getValueByDimension(i)){
                return false;
            }
        }

        return true;
    }

    /**
     * Get the value for the specified dimension i
     */
    public int getValueByDimension(int i) {
        return valuesByDimension[i];
    }

    /**
     * Retrieve a read-only list of the dimensions
     */
    public List<Dimension> getDimensions(){
        try{
            lock.readLock().lock();
            return dimensions;
        }finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Only sets dimensions if it is not already set. Dimensions
     * will be sorted by Dimensions.getOrdinal()
     *
     * Creates a defensive copy of dims
     *
     */
    public void setDimensions(List<Dimension> dims, int numberOfValues){
        List<Dimension> dimsCopy = new ArrayList<>(dims);

        // sort by Dimensions.getOrdinal()
        Collections.sort(dimsCopy);

        try{
            lock.writeLock().lock();
            if(dimensions == null){
                dimensions = Collections.unmodifiableList(dimsCopy);
                valuesPerDimension = numberOfValues;
            }
        }finally {
            lock.writeLock().unlock();
        }
    }

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
}
