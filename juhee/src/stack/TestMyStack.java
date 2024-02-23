package stack;

public class TestMyStack {
    public static void main(String[] args) {
        Integer capacity = 10;
        MyStack<Integer> ms = new MyStack<>(10);

        // before push
        System.out.println("ms.isEmpty() = " + ms.isEmpty());
        System.out.println("ms.isFull() = " + ms.isFull());
        System.out.println("ms.size() = " + ms.size());
        System.out.println("----------------------------------");

        for (int i = 1; i <= capacity; i++) ms.push(i);

        // after push
        System.out.println("ms.isEmpty() = " + ms.isEmpty());
        System.out.println("ms.isFull() = " + ms.isFull());
        System.out.println("ms.size() = " + ms.size());
        System.out.println("----------------------------------");

        // peek test
        for (int i = 1; i <= capacity; i++) {
            System.out.println("ms.peek() = " + ms.peek());
            System.out.println("ms.size() = " + ms.size());
        }
        System.out.println("----------------------------------");

        // pop test
        for (int i = 1; i <= capacity; i++) {
            System.out.println("ms.pop() = " + ms.pop());
            System.out.println("ms.size() = " + ms.size());
        }
        System.out.println("----------------------------------");
    }
}
