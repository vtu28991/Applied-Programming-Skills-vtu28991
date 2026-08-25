import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        // First pass
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                stack.push(result.length());
                result.append(c);
            }

            else if (c == ')') {

                if (!stack.isEmpty()) {
                    stack.pop();
                    result.append(c);
                }

            }

            else {
                result.append(c);
            }
        }

        // Remove unmatched '('
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result.deleteCharAt(index);
        }

        return result.toString();
    }
}