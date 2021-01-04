/**
 * Description: A traveler on a 2D gird begins to travel in the top-left corner of a m x n grid, and a traveler's goal
 *              is to travel to the bottom-right corner. A traveler can only move down or right.
 *              The goal is to find how many ways can a traveler travel to the goal on a grid with dimension m x n.
 *              In this program 'row' is indicated as 'm', and 'column' is indicated as 'n'.
 */

import java.util.HashMap;
public class GridTraveler {
    /**
     * Brute Force:
     *  Time complexity: O(2^(n+m))
     *  Space complexity: O(n+m)
     * */
    static int gridTraveler(int row, int col){
        if(row == 1 && col == 1) return 1;
        if(row == 0 || col == 0) return 0;
        //     gridTraveler(go DOWN, move RIGHT)
        return gridTraveler (row -1, col) + gridTraveler (row, col-1);
    }

    /**
     * Dynamic programming: --> Bottom-up Approach (Tabulation)
     *  Time complexity: O(m*n)
     *  Space complexity: O(m*n)
     */
    static int gridTraveler_dynamic_programming(int row, int col){
        int[][] grid = new int[row][col];
        if(row == 1 && col == 1) return 1;
        if(row == 0 || col == 0) return 0;
        // Fill out the base case--> left column and top row
        for(int i=0; i<row; i++){
            grid[i][0] =1;
        }
        for(int j=0; j<col;j++){
            grid[0][j] = 1;
        }
        for(int i=1; i<row;i++){
            for(int j=1; j<col;j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[row-1][col-1];
    }

    /**
     * Dynamic programming(Top down approach): --> using memorization
     *  Time Complexity: O(m*n)
     *  Space Complexity: O(n+m)
     */
    static int gridTraveler_memo(int row, int col){
        // Used HashMap memo to store the mapping of subproblems to their respective solutions
        HashMap<String,Integer> memo = new HashMap<> ();
        return memo(row, col, memo);
    }
    static int memo(int row, int col, HashMap<String,Integer> memo ){
        String key = row+","+col;
        // Check if the arguments in the memo
        if(memo.containsKey (key)) return memo.get (key);
        if(row == 1 && col == 1) return 1;
        if(row == 0 || col == 0) return 0;
        memo.put (key, memo (row-1, col, memo) + memo (row, col-1, memo));
        return memo.get (key);
    }

    /**
     * Dynamic programming: --> Bottom-up Approach (Optimized Space)
     *  Time complexity: O(m*n)
     *  Space complexity: O(n)
     */
    static int gridTraveler_optimized_space (int row, int col){
        int[] grid = new int[row];
        for (int i = 0; i < row; i++)
            grid[i] = 1;
        for(int i=1;i<col;i++){
            for(int j=1; j<row;j++){
                grid[j] = grid[j] + grid[j-1];
            }
        }
        return grid[row-1];
    }

    static long average(long [] array) {
        long sum = 0;
        for(int i = 0; i< array.length; i++) {
            sum += array[i];
        }
        return sum / (long) array.length;
    }
    static void record_time(int m, int n){
        final int NUMBER_OF_TIMES = 20;
        long start, end;
        long [] time_taken1 = new long [NUMBER_OF_TIMES];
        long [] time_taken2 = new long [NUMBER_OF_TIMES] ;
        long [] time_taken3 = new long [NUMBER_OF_TIMES];
        long [] time_taken4 = new long [NUMBER_OF_TIMES];
        int result1=0, result2=0, result3=0, result4=0, index=0;
        int counter =1;
        while (index< NUMBER_OF_TIMES){
            start = System.nanoTime ();
            result1 = gridTraveler (m,n);
            end = System.nanoTime ();
            time_taken1[index] = end - start;
            System.out.println ("Trial #"+counter +": Time taken of GridTraveler solved by Recursion is: " + time_taken1[index]);

            start = System.nanoTime ();
            result2 = gridTraveler (m,n);
            end = System.nanoTime ();
            time_taken2[index] = end - start;
            System.out.println ("Trial #"+counter +": Time taken of GridTraveler solved by Dynamic Programming with Bottom-up Approach (Tabulation) is: " + time_taken2[index]);

            start = System.nanoTime ();
            result3 = gridTraveler (m,n);
            end = System.nanoTime ();
            time_taken3[index] = end - start;
            System.out.println ("Trial #"+counter +": Time taken of GridTraveler solved by Dynamic Programming with Memorization is: " + time_taken3[index]);

            start = System.nanoTime ();
            result4 = gridTraveler_optimized_space (m,n);
            end = System.nanoTime ();
            time_taken4[index] = end - start;
            System.out.println ("Trial #"+counter +": Time taken of GridTraveler solved by Dynamic Programming with Bottom-up Approach (Optimized Space) is: " + time_taken4[index] +"\n");

            counter++;
            index++;
        }
        long ave1 = average(time_taken1);
        long ave2 = average(time_taken2);
        long ave3 = average(time_taken3);
        long ave4 = average(time_taken4);
        System.out.println ("_________________________________________________________________Result___________________________________________________________________________________");
        System.out.println ("\nGridTraveler solved by Recursion is: " + result1 + "\nGridTraveler solved by Dynamic Programming with Bottom-up Approach (Tabulation) is: " + result2 +
                            "\nGridTraveler solved by Dynamic Programming with Memorization is: " + result3 +
                            "\nGridTraveler solved by Dynamic Programming with Bottom-up Approach (Optimized Space) is: " + result4);
        System.out.println ("_______________________________________________________________Time Taken_________________________________________________________________________________");

        System.out.println ("\nTime taken of GridTraveler solved by Recursion is: " + ave1 + "\nTime taken of GridTraveler solved by Dynamic Programming with Bottom-up Approach (Tabulation) is: " + ave2 +
                            "\nTime taken of GridTraveler solved by Dynamic Programming with Memorization is: "+ ave3 +
                            "\nTime taken of GridTraveler solved by Dynamic Programming with Bottom-up Approach (Optimized Space) is: " + ave4);

    }
    public static void main(String[] args){
        int m=20, n=20;
        record_time(m, n);
    }
    
}
