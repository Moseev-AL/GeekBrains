import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        boolean isStringsEqual = false;
        String userAnswer = "";
        Random rand = new Random();
        int i = rand.nextInt(26);
        String computerString = words[i];
        do {
            userAnswer = getUserAnswer();
            isStringsEqual = compareStrings(computerString, userAnswer);
            if (!isStringsEqual) {
                String MaskedString = getMaskedString(computerString, userAnswer);
                System.out.println("Совпали следующие буквы: " + MaskedString);
                System.out.println("*************************************");
            }
        } while (!isStringsEqual);

        System.out.println("Слово угадано!");
    }

    private static String getMaskedString(String computerString, String userAnswer) {
        char[] retArr = new char[15];
        for (int i = 0; i < 15; i++) {
            if (i < computerString.length()) {
                char cc = computerString.charAt(i);
                if (i < userAnswer.length() && cc == userAnswer.charAt(i)) {
                    retArr[i] = userAnswer.charAt(i);
                } else
                    retArr[i] = 'X';
            } else
                retArr[i] = 'X';
        }
        String retv = new String(retArr);
        return retv;
    }


    private static boolean compareStrings(String str1, String str2) {
        boolean res = str1.equalsIgnoreCase(str2);

        return res;
    }

    public static String getUserAnswer() {
        String str;
        System.out.println(Arrays.toString(words));
        System.out.println("Введите слово и нажмите ENTER");
        str = sc.nextLine();
        return str;
    }
}

