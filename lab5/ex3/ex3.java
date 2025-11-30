
public class ex3 {
    public static void main(String[] args) {
        try {
            String text = "helloWorld testString AbCd";
            String result = text.replaceAll("([A-Z])(?=[a-z])", "!$1!");

            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка обработки: " + e.getMessage());
        }
    }
}
