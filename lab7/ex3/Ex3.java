import java.util.*;
import java.util.concurrent.locks.*;
public class Ex3 {
    static Queue<Integer> warehouse = new LinkedList<>();
    static int currentWeight = 0;
    static ReentrantLock lock = new ReentrantLock();
    static Condition canLoad = lock.newCondition();
    static class Loader extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (warehouse.isEmpty()) return;
                    int weight = warehouse.peek();
                    if (currentWeight + weight > 150) {
                        System.out.println("150 кг набрано. Грузчики ушли разгружать.");
                        currentWeight = 0;
                        canLoad.signalAll();
                    } else {
                        warehouse.poll();
                        currentWeight += weight;
                        System.out.println(Thread.currentThread().getName()+ " взял " + weight + " кг (всего: " + currentWeight + ")");
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        warehouse.addAll(Arrays.asList(30, 40, 50, 20, 60, 70, 10));
        for (int i = 1; i <= 3; i++) {
            new Loader().start();
        }
    }
}
