Given an array p[] of length n used to denote the dimensions of a series of matrices such that dimension of i'th matrix is p[i] * p[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications such that you need to perform minimum number of multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same. Please see examples for more clarifications.

NOTE : As there can be multiple possible answers, the console would print "True" for correct string and "False" for incorrect string. You need to only return a string which performs minimum number of multiplications.

Example 1:

Input: 
n = 5
p[] = {1, 2, 3, 4, 5}
Output: 
(((AB)C)D)
Explaination: 
The total number of multiplications are (1*2*3) + (1*3*4) + (1*4*5) = 6 + 12 + 20 = 38.
Example 2:

Input: 
n = 3
p = {3, 3, 3}
Output: 
(AB)
Explaination: 
The total number of multiplications are (3*3*3) = 27.
Your Task:
You do not need to read input or print anything. Your task is to complete the function matrixChainOrder() which takes n and p[] as input parameters and returns the string with the proper order of parenthesis for n-1 matrices. Use uppercase alphabets to denote each matrix.

Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)

Constraints:
2 ≤ n ≤ 26 
1 ≤ p[i] ≤ 500 






  class Solution{
    static String matrixChainOrder(int p[], int n){
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        // m[i][i] is zero as the cost of multiplying one matrix is zero
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // L is chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Constructing the output string
        return printOptimalParens(s, 1, n - 1);
    }

    static String printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            return String.valueOf((char)('A' + i - 1)); // Naming matrices as 'A', 'B', 'C', etc.
        } else {
            return "(" + printOptimalParens(s, i, s[i][j]) + printOptimalParens(s, s[i][j] + 1, j) + ")";
        }
    }
}
