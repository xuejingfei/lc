package backTrance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() ==0) return result;
        Map<Character, String> map = new HashMap<Character, String>() {
            {
                put('1', "abc");
                put('2', "def");
                put('3', "ghi");
                put('4', "jkl");
                put('5', "mno");
                put('6', "pqrs");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        backTrance(new StringBuilder(), digits, result, map, 0);
        return result;
    }


    private void backTrance(StringBuilder combination, String digits, List<String> result, Map<Character, String> map, int index) {
        if (combination.length() == index) {
            result.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (char c : letters.toCharArray()) {
            combination.append(c);
            backTrance(combination, digits, result, map, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }


}
