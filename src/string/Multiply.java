package string;

public class Multiply {

    private String multiply(String num1,String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int max = num1.length() + num2.length();
        int[] multiply = new int[max];
        for (int i = num1.length()-1;i>=0;i--) {
            int iValue = num1.charAt(i) - '0';
            for (int j = num2.length()-1;j>=0;j--) {
                int jValue = num2.charAt(j)- '0';
                int sum = multiply[i+j+1] + iValue*jValue;
                multiply[i+j+1] = sum%10;
                multiply[i+j] += sum/10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0;i<multiply.length;i++) {
            if (i == 0 && multiply[i] == 0) continue;
            result.append(multiply[i]);
        }
        return result.toString();
    }
}
