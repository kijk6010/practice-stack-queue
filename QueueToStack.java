import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {

    public static class Stack<T> {
        Queue<T> mainQueue = new LinkedList<>();
        Queue<T> subQueue = new LinkedList<>();
        T target = null;

        // push
        public T push(T data) {
            mainQueue.add(data);
            return data;
        }

        // peek
        public T peek() {
          while (mainQueue.size() > 1) {
              subQueue.add(mainQueue.poll());
          }
          target = mainQueue.peek();
          subQueue.add(mainQueue.poll());

          while (subQueue.size() > 0) {
              mainQueue.add(subQueue.poll());
          }
          return target;
        }

        // pop
        public T pop() {
            while (mainQueue.size() > 1) {
                subQueue.add(mainQueue.poll());
            }

            target = mainQueue.poll();
            while (subQueue.size() > 0) {
                mainQueue.add(subQueue.poll());
            }
            return target;
        }

        // empty
        public boolean empty() {
            return mainQueue.isEmpty() && subQueue.isEmpty();
        }

        public int size() {
            return mainQueue.size();
        }
    }

    public static void main (String[] args) {
        Stack stack = new Stack();
        if (stack.empty()) {
            stack.push(1);
            stack.push(2);
            stack.push(3);

            System.out.println(stack.size()); // 3
            System.out.println(stack.peek()); // 3
            stack.push(4);
            System.out.println(stack.peek()); // 4
            System.out.println(stack.pop()); // 4
            System.out.println(stack.pop()); // 3
        }
    }
}
