package backTrance;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * 生成有效括号
     * @return
     */
    public List<String> generateParentesis(int n) {
        List<String> ans =new ArrayList<>();
        backTrance(new StringBuilder(),ans,n,0,0);
        return ans;
    }

    public void backTrance(StringBuilder parentesis,List<String> ans,int max,int open,int close) {
        if (parentesis.length() == max*2) {
            ans.add(parentesis.toString());
            return;
        }
        if (open < max) {
            backTrance(parentesis.append('('),ans,max,open+1,close);
            parentesis.deleteCharAt(parentesis.length()-1);
        }
        if (close<open) {
            backTrance(parentesis.append(')'),ans,max,open,close+1);
            parentesis.deleteCharAt(parentesis.length()-1);
        }
    }
}
