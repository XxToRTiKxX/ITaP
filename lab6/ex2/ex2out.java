public class ex2out {
    public static void main(String[] args) {
        ex2<Integer> stack = new ex2<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());  // 3
        System.out.println(stack.peek()); // 2

        stack.push(4);
        System.out.println(stack.pop());  // 4
    }
}
