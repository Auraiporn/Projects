/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * */
public class PalindromeNumber {
    public static void main(String[] args){
//        boolean isPalindrome = palindromeNumber(121); // true
//        boolean isPalindrome = palindromeNumber(-121); // false
//        boolean isPalindrome = palindromeNumber(10); // false
//        boolean isPalindrome = palindromeNumber(-101); // false
        boolean isPalindrome = palindromeNumber(2222); // true
        System.out.println(isPalindrome);


    }
    static boolean palindromeNumber(int number){
        int rev=0, remainder=0, orginalInt = number;
        if(number<0) return false;
        while(number>0) {
            remainder = number%10;
            rev = rev * 10 + remainder;
            number /=10;
        }
        return (orginalInt==rev)? true:false;

    }
}
