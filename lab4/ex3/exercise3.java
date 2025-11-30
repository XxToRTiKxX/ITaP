import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        try {
            validateEmail(email);
            System.out.println("😎 Email корректен: " + email);

        } catch (CustomEmailFormatException e) {
            System.out.println("😥 Ошибка формата email: " + e.getMessage());
            logException(e);
        } finally {
            scanner.close();
        }
    }

    public static void validateEmail(String email) throws CustomEmailFormatException {
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new CustomEmailFormatException("\nНедопустимый формат email");
        }
    }

    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("exceptions.log", true)) {
            fw.write("Исключение: " + e.toString() + "\n");
        } catch (IOException ioEx) {
            System.out.println("Ошибка при записи лога: " + ioEx.getMessage());
        }
    }
}
