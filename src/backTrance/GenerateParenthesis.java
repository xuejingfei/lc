package backTrance;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * 生成有效括号
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<>();
        backTrance(new StringBuilder(),ans,n,0,0);
        return ans;
    }

    public void backTrance(StringBuilder parenthesis,List<String> ans,int max,int open,int close) {
        if (parenthesis.length() == max*2) {
            ans.add(parenthesis.toString());
            return;
        }
        if (open < max) {
            backTrance(parenthesis.append('('),ans,max,open+1,close);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }
        if (close<open) {
            backTrance(parenthesis.append(')'),ans,max,open,close+1);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }
    }
}
