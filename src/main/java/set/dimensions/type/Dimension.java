package set.dimensions.type;

/**
 * Created by yeison on 3/13/16.
 */
public interface Dimension extends Comparable<Dimension> {


    int getOrdinal();


    @Override
    default int compareTo(Dimension o) {
        return getOrdinal() - o.getOrdinal();
    }

    int getValuesSize();
}
