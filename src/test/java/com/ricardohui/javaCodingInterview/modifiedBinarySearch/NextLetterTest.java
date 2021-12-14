package com.ricardohui.javaCodingInterview.modifiedBinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextLetterTest {

    char[] charList = new char[]{'a', 'c', 'f', 'h'};

    @Test
    void searchNextLetterShouldReturnF() {
        assertEquals('f', NextLetter.searchNextLetter(charList, 'f'));
    }

    @Test
    void searchNextLetterShouldReturnC() {
        assertEquals('c', NextLetter.searchNextLetter(charList, 'b'));
    }

    @Test
    void greaterThanArray(){
        assertEquals('a', NextLetter.searchNextLetter(charList, 'm'));
    }

    @Test
    void assertLastOne(){
        assertEquals('h', NextLetter.searchNextLetter(charList, 'h'));
    }

}