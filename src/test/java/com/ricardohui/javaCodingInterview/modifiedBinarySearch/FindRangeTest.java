package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRangeTest {

    @Test
    void findTheRange() {
        int[] range = FindRange.findRange(new int[]{4, 6, 6, 6, 9}, 6);
        assertEquals(1, range[0]);
        assertEquals(3, range[1]);
    }


    @Test
    void findTheRangeEqual() {
        int[] range = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 10);
        assertEquals(3, range[0]);
        assertEquals(3, range[1]);
    }

    @Test
    void findTheRangeOver() {
        int[] range = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 12);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);
    }

}
