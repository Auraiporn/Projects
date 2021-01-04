/**     Recursive Multiplication
        Write a recursive function that accepts two arguments into the parameters x and y. The
        function should return the value of x times y. Remember, multiplication can be performed
        as repeated addition as follows:
        7 * 4 = 4 + 4 + 4 + 4 + 4 + 4 + 4
 */

public class Multiplication_Recursive {
    public static void main(String[] args){
        int result = multiplication_Recursive (7,4);
        System.out.println (result);
    }

    public static int multiplication_Recursive(int x, int y){
        // We want x to be greater than y if x < y, then swap them
        if(x<y){
            return multiplication_Recursive (y,x);
        } else if (y != 0) {
            // Multiplication can be performed as repeated addition; decrementing the value of x
            return (y + multiplication_Recursive (x-1,y));
        } else{
            return 0;
        }
    }
}
