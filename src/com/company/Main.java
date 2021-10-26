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
//import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String text = args[0];              //Records text input
        String pattern = args[1];           //Records pattern to match
        int matchIndex = -1;
        long startTime = System.nanoTime();
        /*Scanner scan = new Scanner(System.in);

        System.out.println("Enter your text input: ");
        text = 
        */

        matchIndex = stringMatch(text, pattern);
        long endTime = System.nanoTime();
        if(matchIndex >= 0) {               //If there is a match
            System.out.println("\nThe index of the matching substring is ");
            System.out.println(matchIndex);
        }
        else{                               //If there is no match
            System.out.println("\nNo match to pattern ");
            System.out.println(pattern);
        }
        System.out.println("\nElapsed time: ");
        System.out.println((endTime - startTime)/1000000);
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
            System.out.println("Input length must be longer than pattern.")
            return -1;
        }
        int patternLength = pattern.length();
        int textLength = text.length();
        int max = textLength - patternLength;

        System.out.println(text);
        for (int i = 0; i < max; i++){
            int j = 0;
            while (j<patternLength && text.charAt(j)==pattern.charAt(i+j)){
                j++;
            }
            if (j = patternLength)
                return i;
        }
        return -1;
    }

    //visualize prints a formatted representation of the text with the
    //pattern below, lined up with the current indices of comparison.
    public void visualize(int index, String pattern){
        for (int i = 0; i < index; i++){
            System.out.println(" ");
        }
        System.out.println(pattern);
    }
}