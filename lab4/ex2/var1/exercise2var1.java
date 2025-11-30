import java.io.*;

public class exercise2var1 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при открытии файла: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при закрытии файла: " + e.getMessage());
        }
    }
}

