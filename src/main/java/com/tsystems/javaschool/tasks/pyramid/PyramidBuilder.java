package com.tsystems.javaschool.tasks.pyramid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        int listSize = inputNumbers.size();
        double root = getRoot(listSize);
        if (inputNumbers.isEmpty() || inputNumbers.contains(null) || root % 1 != 0) {
            throw new CannotBuildPyramidException();
        }

        int row = (int) (root + 1);
        int column = (int) (row + root);
        int[][] pyramidArray = new int[row][column];

        Collections.sort(inputNumbers);

        ArrayList<Integer> numbers = new ArrayList<>(inputNumbers);
        int index = 0;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = row - 1 - i; j < column - row + 1 + i; j++) {
                if (count % 2 == 0) {
                    pyramidArray[i][j] = numbers.get(index++);
                }
                count++;
            }
            count = 0;
        }

        return pyramidArray;
    }

    private static double getRoot(int size) {
        final double a = 0.5;
        final double b = 1.5;
        final double c = 1;
        double discriminant = Math.pow(b, 2) - 4 * a * (c - size);

        return (-b + Math.sqrt(discriminant)) / (2 * a);
    }
}
