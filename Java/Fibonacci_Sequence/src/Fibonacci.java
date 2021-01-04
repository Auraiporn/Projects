/**
 * Description: The class helps to analyze the time complexity of different algorithms to solve fibonacci sequence, where 
 *              fib(n) = 1,1,2,3,5,8,13,21,34,...
 *                  n  = 1,1,2,3,4,5,6,7,8,9,...
 *              by using Brute Force and Dynamic Programming techniques.
 * Output:      The output is the total time taken of each algorithm to solve nth number of fibonacci sequence.
 */

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    /**
     * Brute Force (Using recursion):
     * Time complexity: O(2^n)
     * Space complexity: O(n) --> counts the function call of the stack size
     */
    static int fib(int n){
        if(n==0 || n==1) return n;
        return fib(n-1)+ fib(n-2);
    }
    /**
     * Dynamic Programming - Tabulation:
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    static int fib_mem_tabulation(int n){
        int[] fibonacci = new int[n+1]; // Included base case
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i=2; i<=n;i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[n];
    }

    /**
     * Top Down - Memorization:
     * Time complexity: O(2n) --> O(n)
     * Space complexity: O(n) --> crates HashMap to store the results of the values
     */
    static int fib_mem_top_down_HashMap(int n){
        Map<Integer,Integer> memo = new HashMap<> ();
        if(n==0 || n==1) return n;
        if(memo.containsKey (n)) return memo.get (n);
        int result = fib(n-1) + fib (n-2);
        memo.put (n,result);
        return result;
    }
    
    /**
     * Bottom-Up Algorithm:
     * Time complexity: O(n)
     * Space complexity: O(1) --> uses variables 'a' and 'b' to keep track of the result
     */
    static int fib_bottom_up(int n){
        if(n==0 || n==1) return n;
        int a=1, b=1;
        for(int i=2;i<n;i++){
            int temp = a+b;
            a=b;
            b=temp;
        }
        return b;
    }
    
    static long average(long [] array) {
        long sum = 0;
        for(int i = 0; i< array.length; i++) {
            sum += array[i];
        }
        return sum / (long) array.length;
    }

    public static void main(String[] args){
        // To obtain the accurate result each algorithm will be tested for n number of times.
        final int NUMBER_OF_TIMES = 20;
        int n = 16;
        int i = 0, counter = 1;
        long start, end;
        long [] time_taken1 = new long [NUMBER_OF_TIMES];
        long [] time_taken2 = new long [NUMBER_OF_TIMES] ;
        long [] time_taken3 = new long [NUMBER_OF_TIMES];
        long [] time_taken4 = new long [NUMBER_OF_TIMES];

        int result_fib =0, result_fib_memorization=0, result_fib_tabulation=0, result_fib_bottom_up=0;
        while (i<NUMBER_OF_TIMES) {
            System.out.println("At trail #"+ counter);
            start = System.nanoTime ();
            result_fib = fib (n);
            end = System.nanoTime ();
            time_taken1[i] = end - start;
            System.out.println ("The (" + n + ") number of Fibonacci Sequence by using brute force approach is:  " + result_fib + "\t\t\t\tIt takes " + time_taken1[i]);

            start = System.nanoTime ();
            result_fib_memorization = fib_mem_top_down_HashMap (n);
            end = System.nanoTime ();
            time_taken2[i] = end - start;
            System.out.println ("The (" + n + ") number of Fibonacci Sequence with dynamic approach (memorization) used HashMap is:  " + result_fib_memorization + "\tIt takes " + time_taken2[i]);

            start = System.nanoTime ();
            result_fib_tabulation = fib_mem_tabulation(n);
            end = System.nanoTime ();
            time_taken3[i] = end - start;
            System.out.println ("The (" + n + ") number of Fibonacci Sequence with dynamic approach (tabulation) is:  " + result_fib_tabulation + "\t\t\tIt takes " + time_taken3[i]);

            start = System.nanoTime ();
            result_fib_bottom_up = fib_bottom_up (n);
            end = System.nanoTime ();
            time_taken4[i] = end - start;
            System.out.println ("The (" + n + ") number of Fibonacci Sequence with bottom up algorithm is:  " + result_fib_bottom_up + "\t\t\t\t\tIt takes " + time_taken4[i] + "\n");

            i++;
            counter++;
        }
        long ave1 = average(time_taken1);
        long ave2 = average(time_taken2);
        long ave3 = average(time_taken3);
        long ave4 = average(time_taken4);
        System.out.println ("____________________________________________Average Time Taken & The Result______________________________________________________________________________"
                            +"\n\nThe (" + n + ") number of Fibonacci Sequence by using brute force approach is:  " + result_fib + "\t\t\t\tIt takes " + ave1 
                            +"\nThe (" + n + ") number of Fibonacci Sequence with dynamic approach (memorization) used HashMap is:  " + result_fib_memorization + "\tIt takes " + ave2 
                            + "\nThe (" + n + ") number of Fibonacci Sequence with dynamic approach used array is:  " + result_fib_tabulation + "\t\t\t\tIt takes " + ave3 
                            +"\nThe (" + n + ") number of Fibonacci Sequence with bottom up algorithm is:  " + result_fib_bottom_up + "\t\t\t\t\tIt takes " + ave4 + "\n");
    }
}

