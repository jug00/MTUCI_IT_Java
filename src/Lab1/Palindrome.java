package Lab1;

public class Palindrome {
    public static String reverseString(String s){
        String reverseString = "";
        for (int i = 0; i < s.length(); i++) {
            reverseString += s.charAt(s.length()-i-1);

        }
        return reverseString;
    }
    public static boolean IsPalindrome(String s){
        if (s.equals(reverseString(s))){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (IsPalindrome(s)){
                System.out.println(s + " - true");
            }
            else{
                System.out.println(s + " - false");
            }
        }
    }
}
