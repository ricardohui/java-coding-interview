package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeilingOfANumberTest {

    @Test
    void searchCeilingOfANumber0() {
        assertEquals(-1, CeilingOfANumber.searchCeilingOfANumber(new int[]{}, 6));
    }

    @Test
    void searchCeilingOfANumber1() {
        assertEquals(0, CeilingOfANumber.searchCeilingOfANumber(new int[]{10}, 6));
    }


    @Test
    void searchCeilingOfANumber() {
        assertEquals(1, CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, 6));
    }

    @Test
    void searchCeilingOfANumber2() {
        assertEquals(4, CeilingOfANumber.searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12));
    }

    @Test
    void searchCeilingOfANumber3() {
        assertEquals(-1, CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6,10}, 17));
    }

    @Test
    void searchCeilingOfANumber4() {
        assertEquals(0, CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6,10}, -1));
    }
}