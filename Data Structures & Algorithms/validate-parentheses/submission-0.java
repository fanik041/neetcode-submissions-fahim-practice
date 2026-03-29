class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (top != pairs.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
