import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                dq.addFirst(x);
            } else if (type == 2) {
                int x = sc.nextInt();
                dq.addLast(x);
            } else if (type == 3) {
                System.out.print(dq.removeFirst() + " ");
            } else {
                System.out.print(dq.removeLast() + " ");
            }
        }
    }
}