/**
 * String permutation (backtracking problem) implemented by using recursion, and its time complexity is O(n!).
 * When the String increases, it takes longer time to perform the task.
 * */
public class String_Permutation {
    public static void main(String[] args){
        String string = "abc";
        char[] s = string.toCharArray();
        string_permutation(s, 0, s.length-1);
    }

    static void string_permutation(char[] s, int startIndex, int endIndex){
        if(startIndex==endIndex) printString(s);
        else{
            for(int i = startIndex; i< s.length; i++){
                swap(s, startIndex, i);
                string_permutation(s, startIndex+1, endIndex);
                swap(s,startIndex, i);
            }
        }
    }
    static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a [j];
        a[j] = temp;
    }
    static void printString(char[] array){
        System.out.println();
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+ " ");
        }
    }

}