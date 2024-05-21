class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // Find the crossover point
        int id1 = findCrossOver(arr, 0, n - 1, x);
        
        // Right index to search
        int id2 = id1 + 1;
        
        // If x is present in arr[], then reduce id1 index
        if (arr[id1] == x) id1--;
        
        // Array to store k closest elements
        int[] ans = new int[k];
        
        // Collect k elements
        int count = 0;
        while (id1 >= 0 && id2 < n && count < k) {
            if (x - arr[id1] < arr[id2] - x) {
                ans[count++] = arr[id1--];
            } else {
                ans[count++] = arr[id2++];
            }
        }

        // Collect remaining elements
        while (count < k && id1 >= 0) {
            ans[count++] = arr[id1--];
        }
        while (count < k && id2 < n) {
            ans[count++] = arr[id2++];
        }
        
        return ans;
    }

    private int findCrossOver(int[] arr, int low, int high, int x) {
        if (arr[high] <= x) {
            return high;
        }
        if (arr[low] > x) {
            return low;
        }
        int mid = (low + high) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        } else if (arr[mid] < x) {
            return findCrossOver(arr, mid + 1, high, x);
        }
        return findCrossOver(arr, low, mid - 1, x);
    }
}

