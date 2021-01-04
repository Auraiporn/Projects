/**
 * This program implements methods that swap two numbers without using a temporary varible.
 *
 */

public class Swap {
    // Using addition and subtraction
    static String swap1(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        return  "a = " + a + " AND b = " + b;
    }
    // Using multiplication and division
    static String swap2(int a, int b){
        a = a * b;
        b = a / b;
        a = a / b;
        return  "a = " + a + " AND b = " + b;
    }
    public static void main(String[] args){
        int a = 2, b = 5;
        //String swap_num = swap1(a,b);
        String swap_num = swap2(a,b);
        System.out.println("Before swapping: a = " + a + " AND b = " + b);
        System.out.println("After swapping: " + swap_num);

    }
}
