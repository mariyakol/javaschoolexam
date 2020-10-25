package com.tsystems.javaschool.tasks.subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }
        if (x.isEmpty()) {
            return true;
        }
        int xSize = x.size();
        int ySize = y.size();
        if (y.isEmpty() || xSize > ySize) {
            return false;
        }

        ArrayList firstSequence = new ArrayList(x);
        ArrayList secondSequence = new ArrayList(y);

        int j = 0;
        for (int i = 0; i < xSize; i++) {
            for (; j < ySize; j++) {
                if (firstSequence.get(i).equals(secondSequence.get(j))) {
                    break;
                }
            }
            if (j == ySize) {
                return false;
            }
        }

        return true;
    }
}
