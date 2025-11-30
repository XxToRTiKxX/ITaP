import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        String filePath = "/Users/ToRTiK/Library/Mobile Documents/com~apple~CloudDocs/МТУСИ/ИТиП/практика/работа/lab6/ex1/war_and_peace.txt";
        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner == null) {
            System.out.println("Ошибка: файл не найден!");
            return;
        }


        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // закрываем Scanner
        scanner.close();

        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // сортируем по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // выводим топ-10
        int limit = Math.min(10, list.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());
        }
    }
}


