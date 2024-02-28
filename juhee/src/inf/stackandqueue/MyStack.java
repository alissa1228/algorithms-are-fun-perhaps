package inf.stackandqueue;

/**
 * 직접 구현하는 스택
 */
public class MyStack<T> {
    private final int capacity;
    private final Object[] stackArray;
    private int top;

    public MyStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be a positive integer.");
        this.capacity = capacity;
        this.stackArray = new Object[capacity];
        this.top = -1;
    }

    /**
     * 맨 위(마지막에 들어온) 값을 반환하고 자료구조에서 제거.
     * @return 스택의 맨 위 element, 스택이 비었을 경우 -1 반환
     */
    public Object pop() {
        if (top >= 0) return stackArray[top--];
        else return - 1;
    }

    /**
     * 파라미터로 받은 값을 스택에 맨 위에 저장
     * @param data
     */
    public void push(Object data) {
        if (top > capacity - 1) throw new IllegalArgumentException("MyStack exceeded its capacity.");
        else stackArray[++top] = data;
    }

    /**
     * 맨 위(마지막에 들어온) 값을 반환하고 자료구조에서 제거하지 않음.
     * @return 스택의 맨 위 element, 스택이 비었을 경우 -1 반환
     */
    public Object peek() {
        if (top >= 0) return stackArray[top];
        else return -1;
    }

    /**
     * 해당 스택에 element가 있는지에 대한 여부
     * @return element있을 경우 false 없는 경우 true
     */
    public Boolean isEmpty() {
        return top == -1;
    }

    /**
     * 스택 내부에 저장된 element의 개수
     * @return 없을 경우 -1, 있을 경우 개수를 반환
     */
    public Integer size() {
        return Math.max(this.top + 1, -1);
    }

    /**
     * 해당 배열이 최대 용량에 다다른지에 대한 여부
     * @return 최대 용량일 경우 true, 아닐 경우 false
     */
    public Boolean isFull() {
        return top == capacity - 1;
    }
}
