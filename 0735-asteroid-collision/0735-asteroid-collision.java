import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision is possible only when:
            // previous asteroid moves right (+)
            // current asteroid moves left (-)
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                int top = stack.peek();

                // Current asteroid is bigger
                if (top < -asteroid) {
                    stack.pop();
                }

                // Both are the same size
                else if (top == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Previous asteroid is bigger
                else {
                    destroyed = true;
                    break;
                }
            }

            // Current asteroid survived
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}