package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    //5 Задача
    public static ArrayList<String> sameVowelGroup(String[] array) {
        HashSet<Character> e_set = new HashSet<>();
        HashSet<Character> set = new HashSet<>();
        ArrayList<String> fin_array = new ArrayList<>();
        List vowelsList = Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'y');
        for (int i = 0; i < array[0].length(); i++) {
            System.out.println(array[0].charAt(i));
            e_set.add(array[0].charAt(i));
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (vowelsList.contains(array[i].charAt(j))) ;
                {
                    set.add(array[i].charAt(j));
                }
                if (e_set.equals(set)) {
                    fin_array.add(array[i]);
                }
            }
            System.out.println(Arrays.toString(e_set.toArray()));
            System.out.println(Arrays.toString(set.toArray()));
            set.clear();
        }
        return fin_array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[]{72, 29, 7, 0, 3}));
        System.out.println(sumDigProd(16, 28));
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
    }
}
