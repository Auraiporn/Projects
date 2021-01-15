import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 ** Determine the most repeated word in a given string.
 * A word is defined as something separated by space without punctuation included.
 * Characters in the string will only include punctuation and letters, but the letters can be uppercase or lowercase.
 * A list of possible punctuation would be [ \\n\\t\\r.,;:!?()] as delimiters.
 * The uppercase and lowercase version of a word should be counted as the same.
 * Singular and plural are counted as different words.
 * If two words are repeated an equal number of times whichever set of words came first should be returned.
 * Take out the list of common words,
 * commonWords = {"the", "a", "or", "an", "it", "and", "but", "is", "are", "of", "on", "to", "was", "were", "in", "that", "i", "your", "his", "their", "her", "you", "me", "all"};
 *  */
public class findMostRepeatedWord {

    public static String findMostRepeatedWord(String s) {
        String mostRepeatedWord = "";
        if(s==null) return null;
        if(s=="") return mostRepeatedWord;
        // Initialize convert all uppercase words to lower case since we count them as the same word
        String[] normalizeGivenString = s.toLowerCase().trim().split("[ \\n\\t\\r.,;:!?()]");
        System.out.println(Arrays.toString(normalizeGivenString));
        // Put all the words in string into the HashMap
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int countWord = 1;
        for(String string: normalizeGivenString){
            if(string.length()>0) {
                if (map.containsKey(string) && !listOfCommonWords().contains(string)) {
                    map.put(string, map.get(string) + countWord);
                } else if (!map.containsKey(string)) {
                    map.put(string, countWord);
                }
            }
        }
        // Loop through the map to find the maximum of value
        int max = 0;
        for(String key: map.keySet()){
            int value = map.get(key);
            if(value > max){
                mostRepeatedWord = key;
                max = value;
            }
        }
        System.out.println("Most repeated word is: " + mostRepeatedWord + ".\nIt is repeated: " + max + " times.");
        return mostRepeatedWord;
    }

    public static HashSet<String> listOfCommonWords(){
        HashSet<String> list = new HashSet<>();
        String[] commonWords = {"the", "a", "or", "an", "it", "and", "but", "is", "are", "of", "on", "to", "was", "were", "in", "that", "i", "your", "his", "their", "her", "you", "me", "all"};
        for(String common: commonWords){
            list.add(common);
        }
        return list;
    }

    public static void main(String[] args) {
        String testString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        findMostRepeatedWord(testString);

        System.out.println();
        String testString2 = "Penguins are aquatic, flightless birds that are highly adapted to life in the water. Their distinct tuxedo-like appearance is called countershading, a form of camouflage that helps keep them safe in the water. Penguins do have wing-bones, though they are flipper-like and extremely suited to swimming. Penguins are found almost exclusively in the southern hemisphere, where they catch their food underwater and raise their young on land.";
        findMostRepeatedWord(testString2);

        System.out.println();
        String testString3 = "Students seek relief from rising prices through the purchase of used copies of textbooks, which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower prices. Most bookstores will also buy used copies back from students at the end of a term if the book is going to be re-used at the school. Books that are not being re-used at the school are often purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores where the books will be sold. Textbook companies have countered this by encouraging faculty to assign homework that must be done on the publisher's website. If a student has a new textbook, then he or she can use the pass code in the book to register on the site. If the student has purchased a used textbook, then he or she must pay money directly to the publisher in order to access the website and complete assigned homework. ";
        findMostRepeatedWord(testString3);

        System.out.println();
        String testString4 = "Sunday morning rain is falling\n" +
                "Steal some covers share some skin\n" +
                "Clouds are shrouding us in moments unforgettable\n" +
                "You twist to fit the mold that I am in\n" +
                "But things just get so crazy living life gets hard to do\n" +
                "And I would gladly hit the road get up and go if I knew\n" +
                "That someday it would lead me back to you\n" +
                "That someday it would lead me back to you\n" +
                "\n" +
                "That may be all I need\n" +
                "In darkness she is all I see\n" +
                "Come and rest your bones with me\n" +
                "Driving slow on Sunday morning\n" +
                "And I never want to leave\n" +
                "\n" +
                "Fingers trace your every outline\n" +
                "Paint a picture with my hands\n" +
                "Back and forth we sway like branches in a storm\n" +
                "Change the weather still together when it ends\n" +
                "\n" +
                "That may be all I need\n" +
                "In darkness she is all I see\n" +
                "Come and rest your bones with me\n" +
                "Driving slow on Sunday morning\n" +
                "And I never want to leave\n" +
                "\n" +
                "But things just get so crazy living life gets hard to do\n" +
                "Sunday morning rain is falling and I'm calling out to you\n" +
                "Singing someday it'll bring me back to you\n" +
                "Find a way to bring myself back home to you\n" +
                "\n" +
                "May not know\n" +
                "\n" +
                "That may be all I need\n" +
                "In darkness she is all I see\n" +
                "Come and rest your bones with me\n" +
                "Driving slow on Sunday morning\n" +
                "Driving slow\n" +
                "\n" +
                "Oh, yeah, yeah...\n" +
                "\n" +
                "There is a flower in your hair.\n" +
                "I'm a flower in your hair.\n" +
                "\n" +
                "Oh, yeah, yeah, oh\n";
        findMostRepeatedWord(testString4);

    }

}
