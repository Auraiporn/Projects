/** Description:    The program implements substitution cipher to encrypt a message of printable ASCII characters 
 *                  with a random shifting amount(k) in the range of 1-5. 
 */

import java.util.Random;
import java.util.Scanner;

public class SubstitutionCipher {
    public static byte[] encrypt_byte(String message, int k){
        byte[] ciphertext = message.getBytes ();
        

        for(int i=0;i<ciphertext.length;i++) {
            char letter = message.charAt (i);

            if (ciphertext[i] >= 65 && ciphertext[i] <= 90) {
                ciphertext[i] = (byte) (ciphertext[i] + k);

                if (ciphertext[i] > 90) {
                    ciphertext[i] = (byte) (ciphertext[i] + 65 - 90 - 1);
                }

            } else if ( ciphertext[i] >= 97 && ciphertext[i] <= 122) {
                ciphertext[i] = (byte) (ciphertext[i] + k);

                if (ciphertext[i] > 122) {
                    ciphertext[i] = (byte) (ciphertext[i] + 97 - 122 - 1);
                }
            }
        }
        return ciphertext;
    }

    public static String printASCII_char(byte [] b){
        String s = new String (b);
        return s;
    }
    public static void print(byte[] b){
        for(int i=0;i<b.length;i++){
            System.out.print (" "+b[i]);
        }

    }
    public static void main(String[] args)  {

        Random rand = new Random ();
        int k = rand.nextInt(5)+1;
        System.out.println(k);
        System.out.print ("Encryption Generator with Random Key\nEnter a message: ");
        Scanner scanner = new Scanner (System.in);
        String message = scanner.nextLine ();

        System.out.println ("A message to be encrypted: " + message);
        byte[] b = encrypt_byte (message, k);
        System.out.println ("An encrypted message: "+printASCII_char (b));
    }
}
