import java.util.regex.*;

public class ex2 {
    public static void main(String[] args) {
        try {
            String password = "Abcdef12";
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{8,24}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректный");
            } else {
                System.out.println("Пароль некорректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка проверки: " + e.getMessage());
        }
    }
}
