package Tasks;

import java.util.*;

public class Task6 {
    // 1 Задание
    public static int bell(int n) {
        int[] row = new int[n];
        int prev;
        int temp;
        row[0] = 1;
        for (int i = 1; i < n; ++i) {
            prev = row[0];
            row[0] = row[i - 1];
            for (int j = 1; j <= i; ++j) {
                temp = row[j];
                row[j] = row[j - 1] + prev;
                prev = temp;
            }
        }
        return row[n - 1];
    }

    // 2 Задание
    public static String translateWord(String word) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        int index = 0;
        StringBuilder finalWord = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
                finalWord.append("yay");
                break;
            }
            if (!vowels.contains(Character.toLowerCase(word.charAt(i)))) {
                index = i;
                continue;
            }
            StringBuilder subWord = new StringBuilder(finalWord.substring(0, index + 1));
            if (Character.toString(word.charAt(0)).matches("[A-Z]")) {
                subWord.replace(0, 1, Character.toString(Character.toLowerCase(subWord.charAt(0))));
                finalWord.delete(0, index + 1);
                finalWord.append(subWord + "ay");
                finalWord.replace(0, 1, Character.toString(Character.toUpperCase(finalWord.charAt(0))));
            } else {
                finalWord.delete(0, index + 1);
                finalWord.append(subWord + "ay");
            }
            break;
        }
        return finalWord.toString();
    }

    public static String translateSentence(String sentence) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        int index = 0;
        StringBuilder finalWord;
        StringBuilder finalSentence = new StringBuilder(sentence);
        boolean dot = false;
        char symb = ' ';
        if (Character.toString(finalSentence.charAt(finalSentence.length() - 1)).matches("\\W")) {
            symb = finalSentence.charAt(finalSentence.length() - 1);
            finalSentence.delete(sentence.length() - 1, sentence.length());
            dot = true;
        }
        String[] words = finalSentence.toString().split(" ");
        finalSentence = new StringBuilder("");
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                finalWord = new StringBuilder(word);
                if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
                    finalWord.append("yay");
                    finalSentence.append(finalWord + " ");
                    break;
                }
                if (!vowels.contains(Character.toLowerCase(word.charAt(i)))) {
                    index = i;
                    continue;
                }
                StringBuilder subWord = new StringBuilder(finalWord.substring(0, index + 1));
                if (Character.toString(word.charAt(0)).matches("[A-Z]")) {
                    subWord.replace(0, 1, Character.toString(Character.toLowerCase(subWord.charAt(0))));
                    finalWord.delete(0, index + 1);
                    finalWord.append(subWord + "ay");
                    finalWord.replace(0, 1, Character.toString(Character.toUpperCase(finalWord.charAt(0))));
                    finalSentence.append(finalWord + " ");
                } else {
                    finalWord.delete(0, index + 1);
                    finalWord.append(subWord + "ay");
                    finalSentence.append(finalWord + " ");
                }
                break;
            }
        }
        if (finalSentence.charAt(finalSentence.length() - 1) == ' ') {
            finalSentence.delete(finalSentence.length() - 1, finalSentence.length());
        }
        if (dot) {
            finalSentence.append(symb);
        }
        return finalSentence.toString();
    }

    // 3 Задание
    public static boolean validColor(String color) {
        if (color.matches("rgb\\(\\d{1,3},\\d{1,3},\\d{1,3}\\)")) {
            ArrayList<Integer> params = new ArrayList<>();
            int index = color.indexOf('(') + 1;
            for (int i = color.indexOf('('); i < color.indexOf(')'); i++) {
                if (color.charAt(i) == ',' || color.charAt(i) == ')') {
                    params.add(Integer.parseInt(color.substring(index, i)));
                    index = i + 1;
                }
            }
            for (int par : params) {
                if (!(0 <= par && par <= 255)) {
                    return false;
                }
            }
            return true;
        }
        if (color.matches("rgba\\(\\d{1,3},\\d{1,3},\\d{1,3},\\d?\\.*\\d+\\)")) {
            ArrayList<Double> params = new ArrayList<>();
            int index = color.indexOf('(') + 1;
            for (int i = color.indexOf('('); i < color.indexOf(')') + 1; i++) {
                if (color.charAt(i) == ',' || color.charAt(i) == ')') {
                    params.add(Double.parseDouble(color.substring(index, i)));
                    index = i + 1;
                }
            }
            for (int i = 0; i < params.size(); i++) {
                if (i == params.size() - 1) {
                    if (!(0 <= params.get(i) && params.get(i) <= 1)) {
                        return false;
                    }
                } else if (!(0 <= params.get(i) && params.get(i) <= 255)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // 4 Задание
    public static String stripUrlParams(String url, String... params) {
        StringBuilder finalUrl = new StringBuilder(url);
        StringBuilder subUrl = new StringBuilder(finalUrl.substring(finalUrl.indexOf("?")));
        finalUrl.delete(finalUrl.indexOf("?"), finalUrl.length());
        for (String par : params) {
            if (subUrl.indexOf(par) != -1) {
                while (subUrl.indexOf(par) != -1) {
                    if (subUrl.charAt(subUrl.indexOf(par) - 1) == '&') {
                        subUrl.delete(subUrl.indexOf(par) - 1, subUrl.indexOf(par) + 3);
                    } else {
                        subUrl.delete(subUrl.indexOf(par), subUrl.indexOf(par) + 3);
                    }
                }
            }
        }
        HashSet<Character> paramsUrl = new HashSet<>();
        for (int i = 0; i < subUrl.length(); i++) {
            if (Character.toString(subUrl.charAt(i)).matches("[a-z]")) {
                if (paramsUrl.contains(subUrl.charAt(i))) {
                    if (subUrl.charAt(subUrl.indexOf(Character.toString(subUrl.charAt(i))) - 1) == '&') {
                        subUrl.delete(subUrl.indexOf(Character.toString(subUrl.charAt(i))) - 1, subUrl.indexOf(Character.toString(subUrl.charAt(i))) + 3);
                    } else {
                        subUrl.delete(subUrl.indexOf(Character.toString(subUrl.charAt(i))), subUrl.indexOf(Character.toString(subUrl.charAt(i))) + 3);
                    }
                } else {
                    paramsUrl.add(subUrl.charAt(i));
                }
            }
        }
        finalUrl.append(subUrl);
        return finalUrl.toString();
    }

    // 5 Задание
    public static Object[] getHastTags(String title) {
        HashMap<String, Integer> mapWords = new HashMap<String, Integer>();
        String[] arrWords = title.split("[,\s]");
        ArrayList<String> hashTags = new ArrayList<>();
        for (String word : arrWords) {
            mapWords.put(word, word.length());
        }
        for (int val : mapWords.values().stream().sorted(Comparator.reverseOrder()).toList()) {
            if (val == 0) continue;
            for (String key : arrWords) {
                if (mapWords.get(key) == val) {
                    hashTags.add("#" + key.toLowerCase());
                }
                if (hashTags.size() == 3) {
                    break;
                }
            }
            if (hashTags.size() == 3) {
                break;
            }
        }
        return hashTags.toArray();
    }

    // 6 Задание
    public static int ulam(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        int i;
        int j;
        for (i = 3, j = 2; j < n; i++) {
            int count = 0;
            for (int k = 0; k < nums.size() - 1; k++) {
                for (int l = k + 1; l < nums.size(); l++) {
                    if (nums.get(k) + nums.get(l) == i)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                nums.add(i);
                j++;
            }
        }
        return i - 1;
    }


    // 7 Задание
    public static String longestNonrepeatingSubstring(String string) {
        int res = 0;
        int index;
        StringBuilder subString = new StringBuilder();
        StringBuilder finalSubString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (subString.indexOf(Character.toString(string.charAt(i))) == -1) {
                subString.append(string.charAt(i));
                if (res < subString.length()) {
                    res = subString.length();
                    finalSubString = new StringBuilder(subString);
                }
            } else {
                index = subString.indexOf(Character.toString(string.charAt(i)));
                subString.delete(0, index + 1);
                subString.append(string.charAt(i));
            }
        }
        return finalSubString.toString();
    }

    // 8 Задание
    public static String converToRoman(int n) {
        StringBuilder res = new StringBuilder();
        int num = n;
        int[] arabian = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arabian.length; i++) {
            res.append(roman[i].repeat(num / arabian[i]));
            num = num % arabian[i];
        }
        return res.toString();
    }

    // 9 Задание
    public static boolean formula(String formula){
        String[] elements = formula.split("\\s=\\s");
        Set<Double> formulaIsCorrect = new HashSet<>();
        for (String el : elements){
            formulaIsCorrect.add(calculate(el));
        }
        return formulaIsCorrect.size() == 1;
    }

    private static double calculate(String s){
        String[] elem = s.split("\\s");
        if (elem.length==1){
            return Double.parseDouble(elem[0]);
        }
        return switch (elem[1]){
            case "+" ->  Double.parseDouble(elem[0]) + Double.parseDouble(elem[2]);
            case "*" ->  Double.parseDouble(elem[0]) * Double.parseDouble(elem[2]);
            case "-" ->  Double.parseDouble(elem[0]) - Double.parseDouble(elem[2]);
            case "/" ->  Double.parseDouble(elem[0]) / Double.parseDouble(elem[2]);
            default -> 0;
        };
    }

    // 10 Задание
    public static boolean palindromeDescendant(int num){
        StringBuilder numString = new StringBuilder(String.valueOf(num));
        StringBuilder numTemp = new StringBuilder(String.valueOf(num));
        numTemp.reverse();
        if (numString.length() == 1) return true;
        if (numString.toString().equals(numTemp.toString())) return true;
        numTemp = new StringBuilder();
        while (numString.length() >= 2){
            for (int i = 0; i < numString.length(); i+=2) {
                numTemp.append(Integer.parseInt(String.valueOf(numString.charAt(i)))
                        + Integer.parseInt(String.valueOf(numString.charAt(i+1))));
            }
            if (numTemp.toString().equals(numTemp.reverse().toString())) return true;
            numTemp.reverse();
            numString = new StringBuilder(numTemp);
            numTemp = new StringBuilder();
        }
        return false;
    }




    public static void main(String[] args) {
        System.out.println("1  - " + bell(3));
        System.out.println("2  - " + translateWord("Cram"));
        System.out.println("2  - " + translateSentence("Do you think it is going to rain today?"));
        System.out.println("3  - " + validColor("rgb(255,41,1144)"));
        System.out.println("4  - " + stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println("5  - " + Arrays.toString(getHastTags("Visualizing, Science")));
        System.out.println("5  - " + Arrays.toString(getHastTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println("6  - " + ulam(9));
        System.out.println("7  - " + longestNonrepeatingSubstring("abcda"));
        System.out.println("8  - " + converToRoman(16));
        System.out.println("9  - " + formula("16 * 10 = 160 = 14 + 120"));
        System.out.println("10  - " + palindromeDescendant(11));
    }
}
