package com.example.helloworld;

/*
 * Milad Awkar
 * Anagram program (or Anagram.java)
 * Checks if two words are anagram
 * runtime: O(n)
 * December 11, 2019
 */


class anagram {

    //usable variable. to check numbers and characters
    //based on ascii. Can be less than 127 but just being safe
    static int charNum = 127;

    public static void main(String[] args) {
        //pass cases
        runAna(isAnagram("cinema", "iceman"));
        runAna(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort!"));
        runAna(isAnagram("Dave Barry", "Ray Adverb"));
        runAna(isAnagram("debit card", "bad credit"));
        runAna(isAnagram("astronomer", "Moon starer"));
        runAna(isAnagram("abc123", "c3b2a1"));
        System.out.println();
        //fail cases
        runAna(isAnagram("banana", "bananas"));
        runAna(isAnagram("bananab", "abanana"));
        runAna(isAnagram("Tom Riddle", "I’m Lord Voldemort?"));
        runAna(isAnagram("abc123", "a11b22c33"));
    }//end of main

    public static boolean isAnagram(String phrase1, String phrase2){
        //replaceAll removes all the special characters and spaces
        //toLowerCase lowers all the letters
        phrase1 = phrase1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        phrase2 = phrase2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // if length of strings is not same, it's not an anagram
        if (phrase1.length() != phrase2.length()){
            //System.out.println("wrong length");//debug
            return false;
        }

        //make a array ascii array for the first 127 entries
        //all start at 0
        int[] ascTable = new int[charNum];

        /*
         *  for phrase1; it will increment the positon of letter/number base on ascii
         *  ex. if 'a', ascTable[97] will increment
         *  for phrase2; it will decrement instead
         *  O(n)
         */
        for (int i = 0; i < phrase1.length(); i++) {
            ascTable[phrase1.charAt(i)]++;
            ascTable[phrase2.charAt(i)]--;
        }

        /*
         *  if it's not an anagram, there will be a non-zero in the array
         *  O(127)
         */
        for(int i=0; i<charNum; i++){
            if(ascTable[i]!=0)
                return false;
        }
        //it will return true if it is anagram
        return true;
    }//end of isAnagram

    //runs isAnagram in main method. print result
    public static void runAna(boolean a){
        if(a)
            System.out.println("anagram");
        else
            System.out.println("NOT anagram");
    }//end of runAna
}//end of class