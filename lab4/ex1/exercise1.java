public class exercise1 {
    public static void main(String[] args) {
        Object[] arr = {1, 2, "три", 4, 5}; 
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) { 
                if (!(arr[i] instanceof Integer)) {
                    throw new NumberFormatException("Элемент не является числом: " + arr[i]);
                }
                sum += (int) arr[i];
                count++;
            }

            double avg = (double) sum / count;
            System.out.println("Среднее арифметическое: " + avg);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за пределы массива. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        }
    }
}
