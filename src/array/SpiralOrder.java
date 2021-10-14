package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /**
     * 螺旋矩阵顺时针打印
     *
     * @param matrix
     * @return
     */
    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, top = 0, right = columns - 1, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for(int colunm = left;colunm<=right;colunm++) {
                result.add(matrix[top][colunm]);
            }
            for(int row = top+1;row<=bottom;row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for(int colunm = right-1;colunm>left;colunm--) {
                    result.add(matrix[bottom][colunm]);
                }
                for(int row = bottom;row>top;row--) {
                    result.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
