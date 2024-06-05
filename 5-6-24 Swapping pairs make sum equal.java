import java.util.HashSet;

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Calculate sums of both arrays
        long sumA = 0;
        long sumB = 0;
        
        for (long num : a) sumA += num;
        for (long num : b) sumB += num;
        
        // If the difference is odd, we cannot find such pairs
        long diff = sumA - sumB;
        if (diff % 2 != 0) return -1;
        
        // Calculate target difference
        diff /= 2;
        
        // Use a set for faster lookup
        HashSet<Long> setB = new HashSet<>();
        for (long num : b) setB.add(num);
        
        // Check for each element in array a
        for (long num : a) {
            if (setB.contains(num - diff)) {
                return 1;
            }
        }
        
        return -1;
    }
}
