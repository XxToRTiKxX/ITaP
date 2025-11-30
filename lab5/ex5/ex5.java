import java.util.regex.*;
import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите букву: ");
            char c = sc.next().charAt(0);

            String text = "Apple and apricot are amazing fruits";
            Pattern pattern = Pattern.compile("\\b" + Character.toLowerCase(c) + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (Exception e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}
