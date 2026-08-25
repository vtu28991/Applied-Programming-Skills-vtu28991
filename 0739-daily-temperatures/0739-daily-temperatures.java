import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Find warmer day for previous days
            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] < temperatures[i]) {

                int previousDay = stack.pop();

                answer[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return answer;
    }
}