package meituanInterview;

import java.util.Stack;

public class TrainStack {
    public static void main(String[] args) {
        int[] enterSequence = {1,2,3};
        int[] leaveSequence = {3,1,2};
        System.out.println(checkTrainSequence(enterSequence, leaveSequence));
    }
    public static boolean checkTrainSequence(int[] enterSequence, int[] leaveSequence) {
        Stack<Integer> stack = new Stack<>();
        int n = enterSequence.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            stack.push(enterSequence[i]);
            while (!stack.empty() && stack.peek() == leaveSequence[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

}
