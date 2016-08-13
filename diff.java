public class diff {
    // find LCS - longest common subsequence
    // LCS-LENGTH implementation from Introduction To Algorithms
    // O(n*m)
    static String s1 = "bdcaba";
    static String s2 = "abcbdab";

    static int[][] b = new int[s1.length() + 1][s2.length() + 1];
    static int[][] c = new int[s1.length() + 1][s2.length() + 1];

    static int MATCH = 0;
    static int UP = 1;
    static int LEFT = 2;

    public static void main(String[] args) {
        int m = s1.length();
        int n = s2.length();


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

        printLCS(m, n);
    }

    // O(m + n)
    public static void printLCS(int lenA, int lenB) {
        if(lenA == 0 || lenB == 0)
            return;
        if (b[lenA][lenB] == MATCH) {
            printLCS(lenA - 1, lenB - 1);
            System.out.print(s1.charAt(lenA - 1));
        } else if (b[lenA][lenB] == UP)
            printLCS(lenA - 1, lenB);
        else printLCS(lenA, lenB - 1);
    }
}
