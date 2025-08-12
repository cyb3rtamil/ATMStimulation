public class Main {
    public int[] stack = new int[100];
    public int top = -1;

    public void push(int x) {
        if (top == stack.length - 1) {
            System.out.println("STACK OVERFLOW");
        } else {
            stack[++top] = x;
            System.out.println("PUSHED : " + x);
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY");
        } else {
            System.out.println("POPED : " + stack[top--]);
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("STACK UNDERFLOW");
        } else {
            System.out.println("TOP : " + stack[top]);
        }
    }

    public void stackfull() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY");
        } else if (top == stack.length - 1) {
            System.out.println("STACK IS FULL");
        } else {
            System.out.println("STACK ELEMENTS ARE:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.push( 10);
        obj.push(20);
        obj.push(30);
        obj.pop();
        obj.peek();
        obj.stackfull();
    }
}