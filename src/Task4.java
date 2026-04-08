import java.util.*;

public class Task4 {

    static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }

    static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        reverse(st);
        insertAtBottom(st, top);
    }

    public static void main(String[] args) {
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
}