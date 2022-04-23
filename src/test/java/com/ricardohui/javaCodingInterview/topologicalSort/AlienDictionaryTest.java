package com.ricardohui.javaCodingInterview.topologicalSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

    @Test
    void findPrecedenceAlphabet1() {
        char[] result = AlienDictionary.findPrecedenceAlphabet("ab", "bb");
        assertEquals('a', result[0]);
        assertEquals('b', result[1]);
    }

    @Test
    void findPrecedenceAlphabet2() {
        char[] result = AlienDictionary.findPrecedenceAlphabet("bc", "bb");
        assertEquals('c', result[0]);
        assertEquals('b', result[1]);
    }

    @Test
    void findPrecedenceAlphabet3() {
        char[] result = AlienDictionary.findPrecedenceAlphabet("bc", "bbb");
        assertEquals('c', result[0]);
        assertEquals('b', result[1]);
    }
}