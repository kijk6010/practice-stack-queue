import java.util.Stack;

/**
 * Stack 2개로 Queue 구현 하기
 */
public class StackToQueue {
    public static class Queue<T> {
        Stack<T> inStack = new Stack<>();
        Stack<T> outStack = new Stack<>();

        // add
        public T add(T data) {
            inStack.add(data);
            return data;
        }

        // poll
        public T poll() {
            if(outStack.isEmpty()) {
                while(inStack.size() > 0) {
                    outStack.add(inStack.pop());
                }
            }
            return outStack.pop();
        }

        // peek
        public T peek() {
            if(outStack.isEmpty()) {
                while(inStack.size() > 0) {
                    outStack.add(inStack.pop());
                }
            }
            return outStack.peek();
        }

        // clear
        public void clear() {
            inStack.clear();
            outStack.clear();
        }

        public int size() {
            return inStack.size();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.size()); // 3
        System.out.println(queue.peek()); // 1
        System.out.println(queue.poll()); // 1 삭제
        System.out.println(queue.peek()); // 2
        queue.add(4); // 2, 3, 4
        System.out.println(queue.poll()); // 2
        System.out.println(queue.size()); // 2
        queue.clear();
        System.out.println(queue.size()); // 0
    }
}
