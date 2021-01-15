/**
 * Find the number of vowels and consonants in a given string
 * Create a method that takes a string input and prints out the number of vowels and
 * the number of consonants in that string input.
 * Vowels: a, e, i, o, u, y
 * */

public class findVowelsAndConsonants {
    public static void main(String [] args){
        printNumOfVowelsAndConsonants("HellO"); // 2 vowels, 3 consonants
        printNumOfVowelsAndConsonants( "there is a quiet Mouse"); // 10 vowels, 8 consonants
        printNumOfVowelsAndConsonants( "I am happy");  // 4 vowels, 4 consonants
    }
    public static void printNumOfVowelsAndConsonants(String s){
        int numOfVowels = 0;
        int numOfConsonants = 0;
        if(s.length()==0) {
            System.out.println(numOfVowels+" vowel/vowels, " + numOfConsonants + " consonant/consonants");
        }else {
            String input = (s.toUpperCase()).trim();
            char[] c= input.toCharArray();
            for(int i=0; i < c.length; i++){
                if (c[i] == 'A' || c[i] == 'E' || c[i] == 'I' || c[i] == 'O' || c[i] == 'U' || c[i] == 'Y'){
                    numOfVowels++;
                }else if (c[i]!= ' ') {
                    numOfConsonants++;
                }
            }
        }
        System.out.println(numOfVowels+" vowel/vowels," + numOfConsonants + " consonant/consonants");
    }
}
