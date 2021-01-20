/**
 * A program to determine if a string has all unique characters.
 * */
public class is_Unique {
    public static void main(String[] args) {
        String s = "car";
        System.out.println(isUnique(s));
    }
    static boolean isUnique(String s){
        if(s.equals("")) return true;
        char[] a = s.toCharArray();
        int n = a.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;j++){
                if(a[i]==a[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
