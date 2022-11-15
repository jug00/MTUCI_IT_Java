package Tasks;

import java.util.*;

public class Task4 {
    public static String bessie(int n, int k, String text){
        StringBuilder fin = new StringBuilder(text);
        int index = 0;
        for (int i = 0; i < fin.length(); i++) {
            if (fin.charAt(i) == ' ' && fin.substring(index,i+1).length() >= k){
                fin.replace(i, i+1,"\n");
                index = i;
            }
        }
        return fin.toString();
    }

    public static Object[] split(String string){
        int open = 0;
        int close = 0;
        ArrayList<String> fin = new ArrayList<>();
        int end_ind = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') open += 1;
            else if (string.charAt(i) == ')') close += 1;
            if (open == close) {
                fin.add(string.substring(end_ind, i + 1));
                end_ind = i+1;
            }
        }
        return fin.toArray();
    }

    public static String toCamelCase(String string){
        StringBuilder fin = new StringBuilder(string);
        for (int i = 0; i < fin.length(); i++) {
            if (fin.charAt(i) == '_') fin.replace(i, i+2, Character.toString(fin.charAt(i+1)).toUpperCase());
        }
        return fin.toString();
    }

    public static String toSnakeCase(String string){
        StringBuilder fin = new StringBuilder(string);
        for (int i = 0; i < fin.length(); i++) {
            if (Character.toString(fin.charAt(i)).matches("[A-Z]")) fin.replace(i, i+1, "_" + Character.toString(fin.charAt(i)).toLowerCase());
        }
        return fin.toString();
    }

    public static String overTime(double st_time, double end_time, double m_h, double coef){
        if (end_time <= 17){
            return "$" + String.format("%.2f", (end_time - st_time) * m_h);
        }
        else return "$" + String.format("%.2f", ((17 - st_time) * m_h + (end_time - 17) * m_h * coef));
    }

    public static String BMI(String weight, String height){
        double w = 0;
        double h = 0;
        for (int i = 0; i < weight.length(); i++) {
            if (weight.charAt(i) == ' '){
                if (weight.endsWith("pounds")) w = Double.parseDouble(weight.substring(0, i)) / 2.205;
                else w = Double.parseDouble(weight.substring(0, i));
            }
        }
        for (int i = 0; i < height.length(); i++) {
            if (height.charAt(i) == ' '){
                if (height.endsWith("inches")) h = Double.parseDouble(height.substring(0, i)) / 39.37;
                else h = Double.parseDouble(height.substring(0, i));
            }
        }
        double res = w / (h*h);
        if (res < 18.5) return String.format("%.1f", res) + " Underweight";
        else if (res >= 18.5 && res <= 24.9) return String.format("%.1f", res) + " Normal weight";
        else return String.format("%.1f", res) + " Overweight";
    }

    public static int bugger(int num){
        if (num < 10) return 0;
        StringBuilder str = new StringBuilder(Integer.toString(num));
        int pr = 1;
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            pr *= Integer.parseInt(Character.toString(str.charAt(i)));
            if (i == str.length() - 1) {
                k += 1;
                if (pr < 10) return k;
                str.replace(0, str.length(), Integer.toString(pr));
                pr = 1;
                i = -1;
            }
        }
        return k;
    }

    public static String toStarShorthand(String string){
        StringBuilder fin = new StringBuilder(string);
        int len = 1;
        int st_index = 0;
        int en_index = 0;
        for (int i = 0; i < fin.length()-1; i++) {
            if (fin.charAt(i) == fin.charAt(i+1)){
                if (len == 1){
                    len += 1;
                    st_index = i;
                    en_index = i + 1;
                }
                else {
                    len += 1;
                    en_index = i + 1;
                }
            }
            else if (len > 1){
                fin.replace(st_index, en_index + 1, fin.charAt(i) + "*" + len);
                len = 1;
                st_index = 0;
                en_index = 0;
                i = -1;
            }
            if (i == fin.length() - 2 && fin.charAt(i+1) == fin.charAt(i)){
                fin.replace(st_index, en_index + 1, fin.charAt(i) + "*" + len);
                len = 1;
                st_index = 0;
                en_index = 0;
                i = -1;
            }
        }
        return fin.toString();
    }

    public static boolean doesRhyme(String str1, String str2){
        String vowel = "aeiuyoAEIUYO";
        ArrayList<String> vowel_word1 = new ArrayList<>();
        ArrayList<String> vowel_word2 = new ArrayList<>();
        for (int i = str1.length()-1; i >= 0 ; i--) {
            if (vowel.contains(Character.toString(str1.charAt(i)).toLowerCase())){
                vowel_word1.add(Character.toString(str1.charAt(i)));
            }
            if (str1.charAt(i) == ' ') break;
        }

        for (int i = str2.length()-1; i >= 0 ; i--) {
            if (vowel.contains(Character.toString(str2.charAt(i)).toLowerCase())){
                vowel_word2.add(Character.toString(str2.charAt(i)));
            }
            if (str2.charAt(i) == ' ') break;
        }
        Collections.sort(vowel_word1);
        Collections.sort(vowel_word2);
        return Arrays.equals(vowel_word1.toArray(), vowel_word2.toArray());
    }

    public static boolean trouble(int num1, int num2){
        String num1_str = Integer.toString(num1);
        String num2_str = Integer.toString(num2);
        int len1 = 1;
        int len2 = 1;
        char num = ' ';
        for (int i = 0; i < num1_str.length()-1; i++) {
            if (num1_str.charAt(i) == num1_str.charAt(i+1)){
                len1 += 1;
                num = num1_str.charAt(i);
            }
            else len1 = 1;
            if (len1 == 3){
                for (int j = 0; j < num2_str.length()-1; j++) {
                    if (num2_str.charAt(j) == num2_str.charAt(j+1) && num2_str.charAt(j) == num){
                        len2 += 1;
                        if (j+1 == num2_str.length()-1){
                            if (len2 == 2) return true;
                        }
                        else{
                            if (num2_str.charAt(j) != num2_str.charAt(j+2) && len2 == 2) return true;
                        }
                    }
                    else len2 = 1;
                    }
                }
            }
        return false;
    }

    public static int countUniqueBooks(String stringSequence, Character bookEnd){
        StringBuilder str = new StringBuilder(stringSequence);
        HashSet<Character> set = new HashSet<>();
        String substr = new String();
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == bookEnd){
                if (index == -1) index = i;
                else {
                    substr = str.substring(index + 1, i);
                    for (int j = 0; j < substr.length(); j++) {
                        set.add(substr.charAt(j));
                    }
                    index = -1;
                }
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        System.out.println(bessie(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println(Arrays.toString(split("((())())(()(()()))")));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(overTime(13.25, 15, 30, 1.5));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(bugger(39));
        System.out.println(toStarShorthand(("abbccc")));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(trouble(53242225, 452322));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
    }
}
