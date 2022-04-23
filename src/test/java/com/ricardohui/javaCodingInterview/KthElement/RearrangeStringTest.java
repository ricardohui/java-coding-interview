package com.ricardohui.javaCodingInterview.KthElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeStringTest {

    @Test
    void rearrangeString_aapa() {

        assertEquals("",RearrangeString.rearrangeString("aapa") );

    }

    @Test
    void rearrangeString_aappp() {

        assertEquals("papap",RearrangeString.rearrangeString("aappp") );

    }

    @Test
    void rearrangeString_Programming() {

        assertEquals("Programming",RearrangeString.rearrangeString("Programming") );

    }
}