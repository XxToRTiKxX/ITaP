import java.io.*;

public class exercise2var2 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int data;
            while (true) {
                try {
                    data = fis.read();
                    if (data == -1) break;
                    fos.write(data);
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении/записи: " + e.getMessage());
                    break;
                }
            }
            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            System.out.println("Ошибка открытия файла: " + e.getMessage());
        }
    }
}

