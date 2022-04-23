package com.ricardohui.javaCodingInterview.KthElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDistinctElementsTest {

    @Test
    void threeDistinct(){
        int maximumDistinctElements = MaximumDistinctElements.findMaximumDistinctElements(
                new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        assertEquals(3,maximumDistinctElements );
    }

    @Test
    void twoDistinct(){
        int maximumDistinctElements = MaximumDistinctElements.findMaximumDistinctElements(
                new int[]{3, 5, 12, 11, 12 }, 3);
        assertEquals(2,maximumDistinctElements );
    }

    @Test
    void threeDistinct2(){
        int maximumDistinctElements = MaximumDistinctElements.findMaximumDistinctElements(
                new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        assertEquals(3,maximumDistinctElements );
    }


}