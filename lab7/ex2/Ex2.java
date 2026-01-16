public class Ex2 {
    static class RowMaxThread extends Thread {
        int[] row;
        int max;
        RowMaxThread(int[] row) {
            this.row = row;
            max = row[0];
        }
        @Override
        public void run() {
            for (int x : row) {
                if (x > max) max = x;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 5, 3},
                {9, 2, 4},
                {6, 8, 7}
        };
        RowMaxThread[] threads = new RowMaxThread[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowMaxThread(matrix[i]);
            threads[i].start();
        }
        int globalMax = matrix[0][0];
        for (RowMaxThread t : threads) {
            t.join();
            if (t.max > globalMax) globalMax = t.max;
        }
        System.out.println("Максимальный элемент: " + globalMax);
    }
}
