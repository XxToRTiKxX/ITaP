import java.util.LinkedHashMap;
import java.util.Map;

public class ex3 {

    private LinkedHashMap<String, Integer> sales = new LinkedHashMap<>();

    public void addSale(String product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
    }

    public void printSales() {
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + " — " + entry.getValue());
        }
    }

    public int totalSales() {
        int sum = 0;
        for (int cnt : sales.values()) sum += cnt;
        return sum;
    }

    public String mostPopular() {
        String best = null;
        int max = 0;
        for (Map.Entry<String, Integer> e : sales.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                best = e.getKey();
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ex3 st = new ex3();
        st.addSale("Apple");
        st.addSale("Milk");
        st.addSale("Apple");
        st.addSale("Bread");
        st.addSale("Apple");

        st.printSales();
        System.out.println("Total: " + st.totalSales());
        System.out.println("Popular: " + st.mostPopular());
    }
}
