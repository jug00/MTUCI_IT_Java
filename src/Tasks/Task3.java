package Tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Task3 {
    public static int solutions(int a, int b, int c){
        int d = b * b - 4 * a * c;
        if (d < 0) return 0;
        else if (d == 0) return 1;
        else return 2;
    }

    public static int findZip(String str){
        int i = str.substring(str.indexOf("zip")+1).indexOf("zip") + str.indexOf("zip") + 1;
        if (i == (str.indexOf("zip"))) return -1;
        else return i;
    }

    public static boolean checkPerfect(int n){
        int i = 0;
        for (int j = 1; j <= n/2; j++) {
            if (n % j == 0) i += j;
        }
        if (n == i) return true;
        else return false;
    }

    public static String flipEndChars(String string){
        if (string.length() < 2) return "Incompatible";
        else if (string.charAt(0) == string.charAt(string.length()-1)) return "Two's a pair";
        else {
            StringBuilder str = new StringBuilder(string);
            char last = str.charAt(str.length() - 1);
            str.setCharAt(str.length() - 1, str.charAt(0));
            str.setCharAt(0, last);
            return str.toString();
        }
    }

    public static boolean isValidHexCode(String code){
        return  (code.charAt(0) == '#' && code.length() == 7 && code.substring(1).matches("[a-fA-F[0-9]]+"));
    }

    public static boolean same(int[] arr1, int[] arr2){
        HashSet set = new HashSet();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int n = set.size();
        set.clear();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        if (n == set.size()) return true;
        else return false;
    }

    public static boolean isKaprekar(int n){
        if (n*n < 10) {
            if (n * n == n) return true;
            else return false;
        }
        else{
           if (Integer.valueOf(Integer.toString(n*n).substring(0, Integer.toString(n*n).length() / 2))
                    + Integer.valueOf(Integer.toString(n*n).substring(Integer.toString(n*n).length() / 2))
                    == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solutions(1, 0, 1));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println(checkPerfect(28));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode(("#CD5C&C")));
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(isKaprekar(297));
    }
}
