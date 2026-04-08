import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] samsas = {1,0,0,0,1,1};

        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) queue.add(s);

        Stack<Integer> stack = new Stack<>();
        for (int i = samsas.length - 1; i >= 0; i--) {
            stack.push(samsas[i]);
        }

        int count = 0;

        while (!queue.isEmpty() && count < queue.size()) {
            if (queue.peek().equals(stack.peek())) {
                queue.poll();
                stack.pop();
                count = 0;
            } else {
                queue.add(queue.poll());
                count++;
            }
        }

        System.out.println(queue.size());
    }
}