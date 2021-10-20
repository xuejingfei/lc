package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    /**
     * 是否是有效括号
     *
     * @param s
     * @return
     */
    public Boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        Stack<Character> stack = new Stack();
        for (char c:s.toCharArray()){
            if (map.containsKey(c)) {
                Character top =  stack.isEmpty() ?'#':stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
