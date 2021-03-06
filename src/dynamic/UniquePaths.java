package dynamic;

public class UniquePaths {
    /**
     * 寻找所有的路径
     * f[i][j] = f[i][j-1] + f[i-1][j]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m,int n) {
        int[][] f = new int[m][n];
        for(int i=0;i<m;i++) f[i][0]=1;
        for(int j=0;j<n;j++) f[0][j]=1;
        for (int i = 1;i<m;i++){
            for(int j = 1;j<n;j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}
