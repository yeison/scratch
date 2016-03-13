package set;

import java.util.Collection;

/**
 * Created by yeison on 3/12/16.
 */
public class SetSolver {


    /**
     * It turns out that any second card may follow any first card.
     * Once the second card is selected, there will be one and only
     * one specific third card that completes the set. Knowing
     * this narrows down the problem space significantly because we
     * only need to perform a cartesian product of the input cards.
     * Then we can perform an O(1) lookup of the specific third card to
     * validate whether the set is possible given the first two cards.
     *
     * This solution runs in O(n^2) where n is the number of cards
     * passed in as input.
     *
     */

    public static void main(String[] args){

    }


    public static void getPossibleSets(Collection<Card> cards){

    }


}
