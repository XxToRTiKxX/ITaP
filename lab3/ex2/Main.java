import java.util.HashMap;

class Order {
    String product;
    String address;
    double cost;

    public Order(String product, String address, double cost) {
        this.product = product;
        this.address = address;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Товар: " + product + ", Адрес: " + address + ", Стоимость: " + cost;
    }
}

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Order> orders = new HashMap<>();


        orders.put(1001, new Order("Ноутбук", "ул. Ленина, 12", 85000));
        orders.put(1002, new Order("Смартфон", "пр. Мира, 5", 45000));
        orders.put(1003, new Order("Наушники", "ул. Кирова, 8", 7000));


        int searchId = 1002;
        System.out.println("Поиск заказа #" + searchId + ":");
        if (orders.containsKey(searchId)) {
            System.out.println(orders.get(searchId));
        } else {
            System.out.println("Заказ не найден.");
        }


        int removeId = 1003;
        System.out.println("\nУдаление заказа #" + removeId + ":");
        orders.remove(removeId);


        System.out.println("Текущие заказы:");
        for (int id : orders.keySet()) {
            System.out.println("№" + id + " -> " + orders.get(id));
        }
    }
}
