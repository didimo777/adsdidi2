import java.util.*;

public class Main {

    // ===== 1 =====
    static void task1(Scanner sc) {
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                row.add(sc.nextInt());
            }
            list.add(row);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }

    // ===== 2 =====
    static void task2(Scanner sc) {
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String cmd = sc.next();

            if (cmd.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
            } else {
                int x = sc.nextInt();
                list.remove(x);
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    // ===== 3 =====
    static void task3(Scanner sc) {
        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();

            if (type == 1) dq.addFirst(sc.nextInt());
            else if (type == 2) dq.addLast(sc.nextInt());
            else if (type == 3) System.out.print(dq.removeFirst() + " ");
            else System.out.print(dq.removeLast() + " ");
        }
    }

    // ===== 4 =====
    static void insertBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int top = st.pop();
        insertBottom(st, x);
        st.push(top);
    }

    static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        reverse(st);
        insertBottom(st, top);
    }

    static void task4() {
        Stack<Integer> st = new Stack<>();
        st.push(9);
        st.push(1);
        st.push(3);
        st.push(5);
        st.push(7);

        reverse(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    // ===== 5 =====
    static void task5() {
        int[] students = {1,1,1,0,0,1};
        int[] samsas = {1,0,0,0,1,1};

        Queue<Integer> q = new LinkedList<>();
        for (int s : students) q.add(s);

        Stack<Integer> st = new Stack<>();
        for (int i = samsas.length - 1; i >= 0; i--) {
            st.push(samsas[i]);
        }

        int count = 0;

        while (!q.isEmpty() && count < q.size()) {
            if (q.peek().equals(st.peek())) {
                q.poll();
                st.pop();
                count = 0;
            } else {
                q.add(q.poll());
                count++;
            }
        }

        System.out.println(q.size());
    }

    // ===== 6 =====
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void task6() {
        int[] arr = {3, 5, 1, 10, 2};
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose task (1-6):");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: task1(sc); break;
            case 2: task2(sc); break;
            case 3: task3(sc); break;
            case 4: task4(); break;
            case 5: task5(); break;
            case 6: task6(); break;
            default: System.out.println("Wrong choice");
        }
    }
}