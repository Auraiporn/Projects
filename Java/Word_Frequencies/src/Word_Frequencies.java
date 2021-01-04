import java.util.HashMap;
/**
 * A program finds the frequency of occurrences of any given word in an input message.
 * */
public class Word_Frequencies {

    public static void main(String[] args) {
        String msg = "I am a good person, and I am a happy girl.";

        display(frequency(msg));
    }
    static HashMap<String, Integer> frequency(String text){
        // Use HashMap to store the words and word counts
        HashMap<String, Integer> freq = new HashMap<>();
        // Split each word by using " " delimiter
        String[] arrayOfText = text.split(" ");
        // Iterate through each element in an array, i.e., iterate through each word
        for(String word: arrayOfText){
            // If a word already exists, increment the counter by 1, otherwise simply assign the value equal to 1
            if(freq.containsKey(word)){
                freq.put(word, freq.get(word)+1);
            } else {
                freq.put(word, 1);
            }
        }
        return freq;
    }

    static void display(HashMap<String, Integer> word_count){
        word_count.entrySet().forEach(entry->{
            System.out.println("["+ entry.getKey() + "] appears " + entry.getValue() + " times.");
        });
    }





}
