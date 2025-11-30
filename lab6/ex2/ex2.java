public class ex2<T> {
    private T[] data;
    private int size;

    public ex2(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length)
            throw new RuntimeException("Stack overflow");
        data[size++] = element;
    }

    public T pop() {
        if (size == 0)
            throw new RuntimeException("Stack is empty");
        return data[--size];
    }

    public T peek() {
        if (size == 0)
            throw new RuntimeException("Stack is empty");
        return data[size - 1];
    }
}
