//Miles Johnson 2021
//CS 350
//Portland State University

//This program takes in "text" input and a "pattern" as command line arguments.
//Both arguments are treated as strings.  A brute-force algorithm for matching
//the pattern to the text is executed.  The program prints a visualization of
//the text compared to the pattern on each iteration of the algorithm, then
//returns the index of the first element in the substring of the text that
//matches the pattern.

package com.company;
import java.util.Random;
import java.lang.StringBuilder;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //Code block adapted from https://www.baeldung.com/java-random-string for generating a random string
        int leftLimit = 41;
        int rightLimit = 122;
        int targetStringLength = 10000;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String text = buffer.toString();
        //End of code from https://www.baeldung.com/java-random-string

        //String text = args[0];              //Records text input
        String pattern = "FA";
        //String pattern = args[1];           //Records pattern to match
        long startTime = System.nanoTime();
        int matchIndex = stringMatch(text, pattern);
        long endTime = System.nanoTime();
        if(matchIndex >= 0) {               //If there is a match
            System.out.print("\nThe index of the matching substring is ");
            System.out.println(matchIndex);
        }
        else{                               //If there is no match
            System.out.println("\nNo match to pattern ");
            System.out.println(pattern);
        }
        System.out.print("\nElapsed time: ");
        System.out.print((endTime - startTime)/1000000);
        System.out.println(" ms");
    }

    //stringMatch iterates through the text, comparing each element to the
    //pattern.  When a character in the text does not match the coinciding
    //character in the pattern, the starting index of comparison increments.
    //If the starting index of comparison is greater than the difference of
    //the length of the text and the length of the pattern, the algorithm
    //returns unsuccessful.  If the entirety of the pattern matches a
    //substring of the text, the program reports a success and returns the
    //starting index of the matching substring in the text.
    public static int stringMatch(String text, String pattern){
        if(text.length() < pattern.length()){
            System.out.println("Input length must be longer than pattern.");
            return -1;
        }
        int patternLength = pattern.length();
        int textLength = text.length();
        int max = textLength - patternLength;

        //System.out.println(text);
        for (int i = 0; i <= max; i++){
            //visualize(i, pattern);
            int j = 0;
            while (j<patternLength && pattern.charAt(j)==text.charAt(i+j)){
                ++j;
            }
            if (j == patternLength) {
                System.out.println("==================");
                System.out.println("Final Comparison:");
                System.out.println(text);
                visualize(i, pattern);
                return i;
            }
        }
        return -1;
    }

    //visualize prints a formatted representation of the text with the
    //pattern below, lined up with the current indices of comparison.
    public static void visualize(int i, String pattern){
        for (int j = 0; j < i; j++){
            System.out.print(" ");
        }
        System.out.println(pattern);
    }
}