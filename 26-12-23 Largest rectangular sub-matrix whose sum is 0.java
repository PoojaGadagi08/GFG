Given a matrix mat[][] of size N x M. The task is to find the largest rectangular sub-matrix by area whose sum is 0.

If there are multiple solutions return the rectangle which starts from minimum column index. If you still have multiple solutions return the one starting from minimum row index. If you still have multiple solutions return the one having greatest row number. If no such matrix is present return a zero (0) size matrix.

Example 1:

Input: N = 3, M = 3
mat[][] =  1, 2, 3
          -3,-2,-1
           1, 7, 5

Output:  1, 2, 3
        -3,-2,-1

Explanation: This is the largest sub-matrix,
whose sum is 0.
Example 2:

Input: N = 4, M = 4
mat[][] = 9, 7, 16, 5
          1,-6,-7, 3
          1, 8, 7, 9
          7, -2, 0, 10

 Output: -6,-7
          8, 7
         -2, 0 
Your Task:
You don't need to read input or print anything. You just have to complete the function sumZeroMatrix() which takes a 2D matrix mat[][], its dimensions N and M as inputs and returns a largest sub-matrix, whose sum is 0.

Expected Time Complexity: O(N*M*M).
Expected Auxiliary Space: O(N*M).


Constraints:
1 <= N, M <= 100
-1000 <= mat[][] <= 1000



  class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int startCol = 0, endCol = 0, startRow = 0, endRow = 0, maxArea = -1001;

        for (int i = 0; i < numCols; i++) {
            int colSum[] = new int[numRows];
            for (int j = i; j < numCols; j++) {
                for (int k = 0; k < numRows; k++) {
                    colSum[k] += matrix[k][j];
                }

                int[] startIndices = { 0 };
                int[] endIndices = { 0 };
                int len = maxLength(colSum, startIndices, endIndices);

                int area = (endIndices[0] - startIndices[0] + 1) * (j - i + 1);

                if (len > 0 && area > maxArea) {
                    startRow = startIndices[0];
                    endRow =endIndices[0];
                    startCol = i;
                    endCol = j;
                    maxArea = area;
                }
            }
        }

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = startRow; i <= endRow; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = startCol; j <= endCol; j++) {
                rowList.add(matrix[i][j]);
            }
            resultList.add(rowList);
        }
        return resultList;
    }

    static int maxLength(int array[], int[] startIndices, int[] endIndices) {
        int sum = 0, maxLength = 0;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] == 0 && maxLength == 0) {
                startIndices[0] = i;
                endIndices[0] = i;
                maxLength = 1;
            }
            if (sum == 0) {
                if (maxLength < i + 1) {
                    startIndices[0] = 0;
                    endIndices[0] = i;
                }
                maxLength = i + 1;
            }
            if (sumIndexMap.containsKey(sum)) {
                int prevLength = maxLength;
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));

                if (maxLength > prevLength) {
                     endIndices[0] = i;
                    startIndices[0] = sumIndexMap.get(sum) + 1;
                  
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        return maxLength;
    }
}
