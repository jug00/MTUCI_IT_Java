package Tasks;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.IntStream;

public class Task5 {
    // 1 задание
    public static int[] encrypt(String string){
        int[] array = new int[string.length()];
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                array[i] = string.charAt(i);
            }
            else{
                array[i] = (int) string.charAt(i) - num;
            }
            num = string.charAt(i);
        }
        return array;
    }

    public static String decrypt(int[] array){
        StringBuilder string = new StringBuilder();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                num = array[i];
                string.append((char) array[i]);
            }
            else{
                string.append((char)(array[i] + num));
                num = array[i] + num;
            }
        }
        return string.toString();
    }
    // 2 задание
    public static boolean camMove(String figure, String start, String end){
        Character[] lines = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        Character[] rows = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String[] figures = new String[]{"king", "queen", "rook", "bishop", "knight", "pawn"};
        if (Arrays.asList(figures).contains(figure.toLowerCase())){
            int indexStartRow = 0;
            int indexStartLine = 0;
            int indexEndRow = 0;
            int indexEndLine = 0;

            for (int i = 0; i < lines.length; i++) {
                if (start.charAt(1) == lines[i]){
                    indexStartLine = i;
                }
                if (end.charAt(1) == lines[i]){
                    indexEndLine = i;
                }
            }

            for (int i = 0; i < rows.length; i++) {
                if (start.charAt(0) == rows[i]){
                    indexStartRow = i;
                }
                if (end.charAt(0) == rows[i]){
                    indexEndRow = i;
                }
            }

            switch (figure.toLowerCase()) {
                case "king":
                    if (Math.abs(indexEndLine - indexStartLine) <= 1 && Math.abs(indexEndRow - indexStartRow) <= 1){
                        return true;
                    }
                case "queen":
                    if (Math.abs(indexEndLine - indexStartLine) == Math.abs(indexEndRow - indexStartRow)){
                        return true;
                    }
                case "rook":
                    if ((Math.abs(indexEndLine - indexStartLine) == 0 && Math.abs(indexEndRow - indexStartRow) != 0)
                            || (Math.abs(indexEndLine - indexStartLine) != 0 && Math.abs(indexEndRow - indexStartRow) == 0)){
                        return true;
                    }
                case "bishop":
                    if ((Math.abs(indexEndLine - indexStartLine) == Math.abs(indexEndRow - indexStartRow))
                            && (Math.abs(indexEndLine - indexStartLine) != 0
                            && Math.abs(indexEndRow - indexStartRow) != 0)){
                        return true;
                    }
                case "knight":
                    if ((Math.abs(indexEndLine - indexStartLine) == 2 && Math.abs(indexEndRow - indexStartRow) == 1)
                            || (Math.abs(indexEndLine - indexStartLine) == 1 && Math.abs(indexEndRow - indexStartRow) == 2)){
                        return true;
                    }
                case "pawn":
                    if (((indexStartLine == 1 || indexStartLine == 6) && Math.abs(indexEndLine - indexStartLine) <= 2 && Math.abs(indexEndRow - indexStartRow) == 0)
                        || (Math.abs(indexEndLine - indexStartLine) <= 1 && Math.abs(indexEndRow - indexStartRow) == 0)){
                        return true;
                    }
            }
        }
        return false;
    }

    // 3 задание
    public static boolean canComplete(String startStr, String finalStr){
        HashMap<Character, Integer> startMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> finalMap = new HashMap<Character, Integer>();
        ArrayList<Character> startArr = new ArrayList<>();
        ArrayList<Character> finalArr = new ArrayList<>();
        for (int i = 0; i < startStr.length(); i++) {
            if (startMap.containsKey(startStr.charAt(i))) {
                startMap.replace(startStr.charAt(i), startMap.get(startStr.charAt(i)) + 1);
            }
            else{
                startMap.put(startStr.charAt(i), 1);
                startArr.add(startStr.charAt(i));
            }
        }
        for (int i = 0; i < finalStr.length(); i++) {
            if (startMap.containsKey(finalStr.charAt(i))){
                if (finalMap.containsKey(finalStr.charAt(i))) {
                    finalMap.replace(finalStr.charAt(i), finalMap.get(finalStr.charAt(i)) + 1);
                }
                else{
                    finalMap.put(finalStr.charAt(i), 1);
                    finalArr.add(finalStr.charAt(i));
                }
            }
        }
        if (startArr.equals(finalArr)){
            for (int i = 0; i < startArr.size(); i++) {
                if (startMap.get(startArr.get(i)) > finalMap.get(finalArr.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    // 4 Задача
    public static int sumDigProd(int ... nums) {
        int pr = 999;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        StringBuilder string = new StringBuilder(Integer.toString(sum));
        while (pr > 9) {
            pr = 1;
            for (int i = 0; i < string.length(); i++) {
                pr *= Integer.parseInt(Character.toString(string.charAt(i)));
            }
            string = new StringBuilder(Integer.toString(pr));
        }
        return pr;
    }

    // 5 Задача
    public static ArrayList<String> sameVowelGroup(String[] words) {
        HashSet<Character> e_set = new HashSet<>();
        HashSet<Character> set = new HashSet<>();
        ArrayList<String> fin_array = new ArrayList<>();
        HashSet<Character> vowelsList = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o'));
        for (int i = 0; i < words[0].length(); i++) {
            if (vowelsList.contains(words[0].charAt(i))) {
                e_set.add(words[0].charAt(i));
            }
        }
        fin_array.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (vowelsList.contains(words[i].charAt(j)))
                {
                    set.add(words[i].charAt(j));
                }
            }
            if (e_set.equals(set)) {
                fin_array.add(words[i]);
            }
            set.clear();
        }
        return fin_array;
    }

    // 6 задание
    public static boolean validateCard(long number){
        if (14 <= Long.toString(number).length() || Long.toString(number).length() <= 19){
            StringBuilder numStr = new StringBuilder(Long.toString(number));
            int ctrl_num = (int) number % 10;
            numStr.deleteCharAt(numStr.length()-1);
            numStr.reverse();
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                int x;
                if (i % 2 != 0) {
                    x = Integer.parseInt(String.valueOf(numStr.charAt(i))) * 2;
                    if (x >= 10) {
                        x = x % 10 + x / 10;
                    }
                }
                else {
                    x = Integer.parseInt(String.valueOf(numStr.charAt(i)));
                }
                sum += x;
            }
            if (10 - sum % 10 == ctrl_num) return true;
        }
        return false;
    }
    // 7 задание
    public static String numToEng(int num){
        StringBuilder string = new StringBuilder();
        HashMap<Integer, String> numsEng = new HashMap<>();
        numsEng.put(0, "zero");
        numsEng.put(1, "one");
        numsEng.put(2, "two");
        numsEng.put(3, "three");
        numsEng.put(4, "four");
        numsEng.put(5, "five");
        numsEng.put(6, "six");
        numsEng.put(7, "seven");
        numsEng.put(8, "eight");
        numsEng.put(9, "nine");
        numsEng.put(10, "ten");
        numsEng.put(11, "eleven");
        numsEng.put(12, "twelve");
        numsEng.put(13, "thirteen");
        numsEng.put(14, "fourteen");
        numsEng.put(15, "fifteen");
        numsEng.put(16, "sixteen");
        numsEng.put(17, "seventeen");
        numsEng.put(18, "eighteen");
        numsEng.put(19, "nineteen");
        numsEng.put(20, "twenty");
        numsEng.put(30, "thirty");
        numsEng.put(40, "forty");
        numsEng.put(50, "fifty");
        numsEng.put(60, "sixty");
        numsEng.put(70, "seventy");
        numsEng.put(80, "eighty");
        numsEng.put(90, "ninety");
        numsEng.put(100, "hundred");
        if (num >= 100){
            string.append(numsEng.get(num / 100) + " ");
            if (num % 100 == 0) {
                string.append(numsEng.get(100));
            }
            else{
                string.append(numsEng.get(100) + " ");
                if (num % 10 == 0){
                    if (num % 100 / 10 * 10 != 0) {
                        string.append(numsEng.get(num % 100 / 10 * 10));
                    }
                }
                else {
                    if (num % 100 / 10 * 10 != 0) {
                        string.append(numsEng.get(num % 100 / 10 * 10) + " ");
                    }
                    string.append(numsEng.get(num % 10));
                }
            }
        }
        else if (100 > num && num > 19 ) {
            if (num % 10 == 0) {
                string.append(numsEng.get(num % 100 / 10 * 10));
            } else {
                string.append(numsEng.get(num % 100 / 10 * 10) + " ");
                string.append(numsEng.get(num % 10));
            }
        }
        else{
            string.append(numsEng.get(num));
        }
        return string.toString();
    }

    public static String numToRus(int num){
        StringBuilder string = new StringBuilder();
        HashMap<Integer, String> numsRus = new HashMap<>();
        numsRus.put(0, "ноль");
        numsRus.put(1, "один");
        numsRus.put(2, "два");
        numsRus.put(3, "три");
        numsRus.put(4, "четыре");
        numsRus.put(5, "пять");
        numsRus.put(6, "шесть");
        numsRus.put(7, "семь");
        numsRus.put(8, "восемь");
        numsRus.put(9, "девять");
        numsRus.put(10, "десять");
        numsRus.put(11, "одиннадцать");
        numsRus.put(12, "двенадцать");
        numsRus.put(13, "тринадцать");
        numsRus.put(14, "четырнадцать");
        numsRus.put(15, "пятнадцать");
        numsRus.put(16, "шестнадцать");
        numsRus.put(17, "семнадцать");
        numsRus.put(18, "восемнадцать");
        numsRus.put(19, "девятнадцать");
        numsRus.put(20, "двацдать");
        numsRus.put(30, "тридцать");
        numsRus.put(40, "сорок");
        numsRus.put(50, "пятьдесят");
        numsRus.put(60, "шестьдесят");
        numsRus.put(70, "семьдесят");
        numsRus.put(80, "восемьдесят");
        numsRus.put(90, "девяносто");
        numsRus.put(100, "сто");
        numsRus.put(200, "двести");
        numsRus.put(300, "триста");
        numsRus.put(400, "четыреста");
        numsRus.put(500, "пятьсот");
        numsRus.put(600, "шестьсот");
        numsRus.put(700, "семьсот");
        numsRus.put(800, "восемьсот");
        numsRus.put(900, "девятьсот");
        if (num >= 100){
            if (num % 100 == 0) {
                string.append(numsRus.get(num / 100 * 100));
            }
            else{
                string.append(numsRus.get(num / 100 * 100) + " ");
                if (num % 10 == 0){
                    if (num % 100 / 10 * 10 != 0) {
                        string.append(numsRus.get(num % 100 / 10 * 10));
                    }
                }
                else {
                    if (num % 100 / 10 * 10 != 0) {
                        string.append(numsRus.get(num % 100 / 10 * 10) + " ");
                    }
                    string.append(numsRus.get(num % 10));
                }
            }
        }
        else if (100 > num && num > 19 ) {
            if (num % 10 == 0) {
                string.append(numsRus.get(num % 100 / 10 * 10));
            } else {
                string.append(numsRus.get(num % 100 / 10 * 10) + " ");
                string.append(numsRus.get(num % 10));
            }
        }
        else{
            string.append(numsRus.get(num));
        }
        return string.toString();
    }

    // 8 задание
    public static String getSha256Hash(String stringToHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(stringToHash.getBytes());
        byte[] digest = md.digest();
        HexFormat hex = HexFormat.of();
        String hexString = hex.formatHex(digest);
        return hexString;
    }

    // 9 задание
    public static String correctTitle(String title){
        StringBuilder correctTitle = new StringBuilder();
        ArrayList<StringBuilder> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < title.length(); i++) {
            if (i == title.length()-1){
                temp.append(Character.toLowerCase(title.charAt(i)));
                words.add(temp);
            }
            else if (title.charAt(i) != ' ' && title.charAt(i) != '-' && title.charAt(i) != '.') {
                temp.append(Character.toLowerCase(title.charAt(i)));
            }
            else{
                words.add(temp);
                temp = new StringBuilder("");
            }
        }
        for (StringBuilder word : words){
            if (word.toString().equals("and") || word.toString().equals("the") || word.toString().equals("of") || word.toString().equals("in")){
                correctTitle.append(word);
                correctTitle.append(" ");
            }
            else{
                String firstCharUpper = String.valueOf((Character.toUpperCase(word.charAt(0))));
                correctTitle.append(word.replace(0,1, firstCharUpper));
                if (word.charAt(word.length()-1) != '.'){
                    correctTitle.append(" ");
                }
            }
        }
        return correctTitle.toString();
    }

    // 10 задание
    public static String hexLattice(int n){
        if (n == 1){
            return " o ";
        }
        else{
            n -= 1;
            int numOfSix = 1;
            while (n > 0){
                n -= numOfSix * 6;
                numOfSix += 1;
            }
            if (n < 0){
                return "Invalid";
            }
            else{
                StringBuilder result = new StringBuilder();
                int centre = numOfSix * 2 - 1;
                int secCountOfSix = numOfSix;
                int numOfSpace = numOfSix;
                for (int i = 0; i < numOfSix; i++) {
                    result.append(" ".repeat(Math.max(0, numOfSpace)));
                    result.append("o ".repeat(numOfSix));
                    result.append(" ".repeat(Math.max(0, numOfSpace - 1)));
                    result.append("\n");
                    numOfSpace -= 1;
                    numOfSix += 1;
                    if (centre == numOfSix){
                        break;
                    }
                }

                result.append(" ");
                result.append("o ".repeat(Math.max(0, centre)));
                result.append('\n');

                numOfSix = centre - 1;
                numOfSpace = numOfSpace + 1;
                for (int i = 0; i < secCountOfSix - 1; i++) {
                    result.append(" ".repeat(Math.max(0, numOfSpace)));
                    result.append("o ".repeat(Math.max(0, numOfSix)));
                    result.append(" ".repeat(Math.max(0, numOfSpace - 1)));
                    result.append("\n");
                    numOfSix -= 1;
                    numOfSpace += 1;
                }
                return result.toString();
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[]{72, 29, 7, 0, 3}));
        System.out.println(camMove("Pawn", "C3", "C5"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println(sumDigProd(16, 28));
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(validateCard(1234567890123452l));
        System.out.println(numToEng(0));
        System.out.println(numToRus(909));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(hexLattice(7));
    }
}
