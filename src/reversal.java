import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
public class reversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Array, Stack, and Queue Reversal");
        System.out.println("--------------------------------");
        System.out.print("How many values would you like to enter? ");
        int size = input.nextInt();

        if (size < 0) {
            System.out.println("Please enter a non-negative number.");
            input.close();
            return;
        }
        int[] numbers = new int[size];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = input.nextInt();

            numbers[i] = value;
            stack.push(value);
            queue.offer(value);
        }

        System.out.println("\nOriginal Collections:");

        System.out.print("The values in the Array are now: ");
        printArray(numbers);
        System.out.print("The values in the Stack collection are now: ");
        printCollection(stack);

        System.out.print("The values in the Queue collection are now: ");
        printCollection(queue);
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        Collections.reverse(stack);
        Stack<Integer> temporaryStack = new Stack<>();

        while (!queue.isEmpty()) {
            temporaryStack.push(queue.poll());
        }

        while (!temporaryStack.isEmpty()) {
            queue.offer(temporaryStack.pop());
        }
        System.out.println("\nReversed Collections:");

        System.out.print("The reversed values in the Array are now: ");
        printArray(numbers);
        System.out.print(
                "The reversed values in the Stack collection are now: ");
        printCollection(stack);
        System.out.print(
                "The reversed values in the Queue collection are now: ");
        printCollection(queue);

        input.close();
    }
    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);

            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void printCollection(
            Iterable<Integer> collection) {
        boolean first = true;

        for (int value : collection) {
            if (!first) {
                System.out.print(", ");
            }

            System.out.print(value);
            first = false;
        }
        System.out.println();
    }
}
