import java.util.regex.*;

public class ex4 {
    public static void main(String[] args) {
        try {
            String ip = "192.168.0.255";
            String octet = "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)";
            Pattern pattern = Pattern.compile("^(" + octet + "\\.){3}" + octet + "$");
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP-адрес корректный");
            } else {
                System.out.println("IP-адрес некорректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка проверки: " + e.getMessage());
        }
    }
}
