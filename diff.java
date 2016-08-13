public class diff {
    public static int MATCH = 0;
    public static int UP = 1;
    public static int LEFT = 2;

    public static void main(String[] args) {
        // find LCS - longest common subsequence
        // LCS-LENGTH implementation from Introduction To Algorithms
        // O(n*m)
        String s1 = "bdcaba";
        String s2 = "abcbdab";

        int m = s1.length();
        int n = s2.length();

        int[][] b = new int[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];

        // set first columnd and row to 0
        for(int i = 0; i <= m; i++)
            c[i][0] = 0;
        for(int j = 0; j <= n; j++)
            c[0][j] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = MATCH;
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = UP;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = LEFT;
                }
            }
        }
    }
}
