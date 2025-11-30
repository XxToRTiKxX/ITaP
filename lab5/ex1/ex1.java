import java.util.regex.*;

public class ex1 {
    public static void main(String[] args) {
        try {
            String text = "The price is 19.99 and the code is 123 and 0.5";
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (Exception e) {
            System.out.println("Ошибка обработки текста: " + e.getMessage());
        }
    }
}

