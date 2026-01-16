public class Ex1 {
    static class SumThread extends Thread {
        private int[] arr;
        private int start, end;
        int sum = 0;
        SumThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8};
        SumThread t1 = new SumThread(arr, 0, arr.length / 2);
        SumThread t2 = new SumThread(arr, arr.length / 2, arr.length);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int totalSum = t1.sum + t2.sum;
        System.out.println("Сумма массива: " + totalSum);
    }
}
