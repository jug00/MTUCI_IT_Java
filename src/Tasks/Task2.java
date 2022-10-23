package Tasks;

import java.util.Arrays;

public class Task2 {
    public static String repeat(String string, int n){
        String res = "";
        for (int i = 0; i < string.toCharArray().length; i++) {
            for (int j = 0; j < n; j++) {
                res += string.toCharArray()[i];
            }
        }
        return res;
    }

    public static int differenceMaxMin(int[] array){
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }

    public static boolean isAvgWhole(int[] array){
        if (Arrays.stream(array).sum() / (double) array.length == Arrays.stream(array).sum() / array.length)
            return true;
        else return false;
    }

    public static int[] cumulativeSum(int[] array){
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = Arrays.stream(Arrays.copyOfRange(array, 0, i+1)).sum();
        }
        return res;
    }

    public static int getDecimalPlaces(String n){
        if (n.indexOf('.') == -1) return 0;
        else return n.substring(n.indexOf('.')+1).length();
    }

    public static int Fibonacci(int n){
        int firstNum = 1;
        int secondNum = 1;
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            res = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = res;
        }
        return res;
    }

    public static boolean isValid(String index) {
        if (index.length() == 5 && index.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    public static boolean isStrangePair(String first, String second){
        if (first.length() == 0 && second.length() == 0) return true;
        else if (first.charAt(first.length()-1) == second.charAt(0) && second.charAt(second.length()-1) == first.charAt(0)){
            return true;
        }
        else return false;
    }

    public static boolean isPrefix(String word, String prefix){
        if (prefix.equals(word.substring(0, prefix.length() - 1) + "-")) return true;
        else return false;
    }

    public static boolean isSuffix(String word, String suffix){
        if (suffix.equals("-" + word.substring(suffix.length()))) return true;
        else return false;
    }

    public static int boxSeq(int n){
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if (i != 0) {
                if (i % 2 == 1) res += 3;
                else if (i % 2 == 0) res -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("1  - " + repeat("mice", 5));
        System.out.println("2  - " + differenceMaxMin(new int[]{-30, 1, 2, 50}));
        System.out.println("3  - " + isAvgWhole(new int[]{9, 2, 2, 5}));
        System.out.println("4  - " + Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println("5  - " + getDecimalPlaces("3.124"));
        System.out.println("6  - " + Fibonacci(12));
        System.out.println("7  - " + isValid("59001"));
        System.out.println("8  - " + isStrangePair("sparkling", "groups"));
        System.out.println("9  - " + isPrefix("automation", "auto-"));
        System.out.println("9  - " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("10 - " + boxSeq(1));
    }
}
