package com.ricardohui.javaCodingInterview.KthElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeStringKDistanceApartTest {

    @Test
    void reorganizeString1() {
        assertEquals("pmpm", RearrangeStringKDistanceApart.reorganizeString(
                "mmpp", 2));
    }

    @Test
    void reorganizeString2() {
        assertEquals("rgmPrgmiano", RearrangeStringKDistanceApart.reorganizeString(
                "Programming", 3));
    }


    @Test
    void reorganizeString3() {
        assertEquals("aba", RearrangeStringKDistanceApart.reorganizeString(
                "aab", 2));
    }

    @Test
    void reorganizeString4() {
        assertEquals("", RearrangeStringKDistanceApart.reorganizeString(
                "aappa", 3));
    }

    @Test
    void reorganizeString5() {
        assertEquals("bab",
                     RearrangeStringKDistanceApart.reorganizeString("abb", 2));
    }
}