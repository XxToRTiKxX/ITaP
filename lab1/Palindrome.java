import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите слово: ");
            String s = sc.nextLine();
            if (isPalindrome(s)) {
                System.out.println(s + " — палиндром");
            } else {
                System.out.println(s + " — не палиндром");
            }
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
}