package com.ricardohui.javaCodingInterview.modifiedBinarySearch;


class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int start = 0;
        int end = letters.length-1;



        while (start <= end) {
            int midpoint = start + (end - start) / 2;

            if (letters[midpoint] < key) {
                start = midpoint + 1;
            } else if (letters[midpoint] > key) {
                end = midpoint -1;
            }else{
                // found
                return letters[midpoint];
            }


        }

        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}