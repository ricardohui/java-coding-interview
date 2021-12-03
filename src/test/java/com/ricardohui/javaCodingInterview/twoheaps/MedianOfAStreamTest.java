package com.ricardohui.javaCodingInterview.twoheaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfAStreamTest {

    @Test
    void insertNum() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(5);

        assertEquals(1, medianOfAStream.minHeap.poll());
        assertEquals(2, medianOfAStream.minHeap.poll());
    }

    @Test
    void insertNum2() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(4);
        medianOfAStream.insertNum(6);

        assertEquals(1, medianOfAStream.minHeap.poll());
        assertEquals(2, medianOfAStream.minHeap.poll());
    }

    @Test
    void findMedian1() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(5);

        assertEquals(2,medianOfAStream.findMedian());
    }

    @Test
    void findMedian2() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(4);
        medianOfAStream.insertNum(8);

        assertEquals(3,medianOfAStream.findMedian());
    }
}