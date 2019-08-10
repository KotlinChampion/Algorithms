package rz.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/*
 * Write a function that receives an array of integers and a number n and returns the nth largest value.
 */

public class NthLargest {

    public static int nthLargest(int[] array, int nth) {
        if ( array == null || array.length < nth) return Integer.MIN_VALUE;

        Queue<Integer> pQueue = new PriorityQueue<Integer>();

        for (int value: array) {
            pQueue.add(value);
            if(pQueue.size() > nth) pQueue.poll();
        }

        return pQueue.poll();
    }

    @Test
    public void test1() { Assert.assertEquals(4, nthLargest(new int[]{1, 2, 3, 4, 5}, 2)); }

    @Test
    public void test2() { Assert.assertEquals(2, nthLargest(new int[] {1,2,3,4,5}, 4)); }

    @Test
    public void test3() { Assert.assertNotEquals(4, nthLargest(new int[] {1,2,3,4,5}, 4)); }

    @Test
    public void test4() { Assert.assertEquals(Integer.MIN_VALUE, nthLargest(new int[] {1,2,3,4,5}, 8)); }

    @Test
    public void test5() { Assert.assertEquals(Integer.MIN_VALUE, nthLargest(null, 4)); }
}
