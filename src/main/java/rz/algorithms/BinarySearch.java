package rz.algorithms;

import org.junit.Assert;
import org.junit.Test;

/*
 * Write a function that binary searches a sorted array of integers for an integer and returns the position of it in the array.
 */
public class BinarySearch {

    public static int search(int[] array, int value) {
        return search(array, value, 0, array.length - 1);
    }

    static int search(int[] array, int value, int lower, int upper) {
        int middle = (lower + upper) / 2;

        if (array[middle] == value) return middle;
        if (lower == upper) return -1;

        if (array[middle] < value) return search(array, value, middle + 1, upper);
        else return search(array, value, lower, middle);
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, search(new int[]{0, 4, 6, 10}, 4));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, search(new int[]{0, 4, 6, 10}, 5));
    }

    @Test
    public void test3() {
        Assert.assertEquals(11, search(new int[]{0, 4, 6, 10, 11, 12, 13, 14, 15, 16, 17, 18},
                18));
    }
}
