package stack_and_queues;

class twoStacks {
    // Array to store elements for both stacks
    int[] arr = new int[100]; // Fixed size array for both stacks
    int top1 = -1;            // Top pointer for stack1 (starts from the left end)
    int top2 = arr.length;    // Top pointer for stack2 (starts from the right end)

    // Constructor to initialize the array with default values (-1)
    twoStacks() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;      // Initialize all elements with -1 (optional)
        }
    }

    // Function to push an integer into stack1 (left side stack)
    void push1(int x) {
        if (top1 + 1 < top2) {   // Check for space between two stacks
            top1++;              // Increment top1 for stack1
            arr[top1] = x;       // Assign value to stack1
        } else {
            System.out.println("Stack1 Overflow"); // Handle overflow
        }
    }

    // Function to push an integer into stack2 (right side stack)
    void push2(int x) {
        if (top2 - 1 > top1) {   // Check for space between two stacks
            top2--;              // Decrement top2 for stack2
            arr[top2] = x;       // Assign value to stack2
        } else {
            System.out.println("Stack2 Overflow"); // Handle overflow
        }
    }

    // Function to remove and return the top element from stack1
    int pop1() {
        if (top1 == -1) {        // Check if stack1 is empty
            return -1;           // Return -1 if no elements in stack1
        } else {
            return arr[top1--];  // Return top element and decrease top1
        }
    }

    // Function to remove and return the top element from stack2
    int pop2() {
        if (top2 == arr.length) { // Check if stack2 is empty
            return -1;            // Return -1 if no elements in stack2
        } else {
            return arr[top2++];    // Return top element and increase top2
        }
    }
}

