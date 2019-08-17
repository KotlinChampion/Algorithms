package rz.algorithms;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * Write a function that finds an returns the an array of uniques from an array of values
 */

public class Uniques {

    public static Integer[] findUnique(int[] array) {

        Set<Integer> once = new HashSet<>();
        Set<Integer> multipleTimes = new HashSet<>();

        for (int value : array) {
            if (multipleTimes.contains(value)) {
                // We can ignore this value since it already is not considered for the uniques
            } else if (once.contains(value)) {
                once.remove(value);
                multipleTimes.add(value);
            } else {
                once.add(value);
            }
        }
        Integer[] uniques = new Integer[once.size()];
        return once.toArray(uniques);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(
                new Integer[]{1, 2, 4},
                findUnique(new int[]{1, 2, 3, 3, 4}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(
                new Integer[]{1, 2},
                findUnique(new int[]{1, 2, 3, 3, 4, 3, 3, 3}));
    }
}
