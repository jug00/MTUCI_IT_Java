package Tasks;

import java.util.Arrays;
import java.util.HashSet;


public class Task3 {
    public static int solutions(int a, int b, int c){
        int d = b*b - 4*a*c;
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
        return  (code.charAt(0) == '#' && code.length() == 7
                && code.substring(1).matches("[a-fA-F[0-9]]+"));
    }

    public static boolean same(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
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
        if (n*n < 10 && n * n == n) return true;
        else{
            int beginIndex = Integer.toString(n * n).length() / 2;
            if (Integer.parseInt(Integer.toString(n*n).substring(0, beginIndex))
                    + Integer.parseInt(Integer.toString(n*n).substring(beginIndex))
                    == n) return true;
        }
        return false;
    }

    public static String longestZero(String str){
        int l = 1;
        int longest = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i) && str.charAt(i) == '0'){
                l += 1;
                if (l > longest) longest = l;
            }
            else l = 1;
        }
        return "0".repeat(longest);
    }

    public static int nextPrime(int n){
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                flag = false;
                break;
            }
        }
        if (flag == true) return n;
        int num = n;
        while (true){
            num++;
            flag = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0){
                    flag = false;
                    break;
                }
            }
            if (flag == true) return num;
        }
    }

    public static boolean rightTriangle(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x) {
            int[] arr = new int[]{x, y, z};
            int[] arr1 = Arrays.stream(arr).sorted().toArray();
            if (arr1[2]*arr1[2] == arr1[0]*arr1[0] + arr1[1]*arr1[1]) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("1  - " + solutions(1, 0, 1));
        System.out.println("2  - " + findZip("all zip files are compressed"));
        System.out.println("3  - " + checkPerfect(28));
        System.out.println("4  - " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("5  - " + isValidHexCode(("#CD5C&C")));
        System.out.println("6  - " + same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("7  - " + isKaprekar(297));
        System.out.println("8  - " + longestZero("01100001011000"));
        System.out.println("9  - " + nextPrime(24));
        System.out.println("10 - " + rightTriangle(145,105,100));
    }
}
