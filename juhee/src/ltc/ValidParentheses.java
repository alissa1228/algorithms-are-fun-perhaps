package ltc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /**
     1. Conver String s to Char array by using .toCharArray();
     2. declare a map<char, char> for check the type of character
     2. declare a char stack
     3. if the char is in ['(', '{', '['] push the character into stack
     4. if the character is in [')', '}', ']']
     4-A. if stack is empty return false
     4-B. if character in stack does not matches its type return false
     4-C. else pop the character in the stack
     5. after searching through loop, if the stack is not empty, return false;
     */
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else {
                    char tmp = stack.pop();
                    if (map.get(tmp) != c) return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
