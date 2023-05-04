

public static int maxCoins(int n,int ranges[][])
    {
         // Sort the ranges array based on the end_i value of each range, breaking ties by start_i value.
    Arrays.sort(ranges, new Comparator<int[]>() {
        public int compare(int[] range1, int[] range2) {
            if (range1[1] != range2[1]) {
                return range1[1] - range2[1];
            }
            return range1[0] - range2[0];
        }
    });

    // Create a list to hold the ranges and their corresponding coin values.
    List<Map.Entry<Integer, Integer>> rangeList = new ArrayList<>();
    // Initialize the maximum number of coins to 0.
    int maxCoins = 0;
    // Iterate through each range in the sorted ranges array.
    for (int[] range : ranges) {
        // Calculate the maximum number of coins that can be collected from ranges with end_i <= start_i of the current range.
        // Add the coin value of the current range to this value to get the total number of coins that can be collected from all ranges ending before the start_i of the current range.
        // Update the maximum number of coins if this value is greater than the current maximum number of coins.
        maxCoins = Math.max(maxCoins, getMaximumCoinsInRange(rangeList, range[0]) + range[2]);
        // If the rangeList is empty or the last range in the list has a coin value less than the current range, add the current range to the list.
        if (rangeList.isEmpty() || rangeList.get(rangeList.size()-1).getValue() < range[2]) {
            rangeList.add(new AbstractMap.SimpleEntry<>(range[1], range[2]));
        }
    }
    // Return the maximum number of coins that can be collected.
    return maxCoins;
}

// Returns the maximum number of coins that can be collected from ranges with end_i <= end.
private static int getMaximumCoinsInRange(List<Map.Entry<Integer, Integer>> rangeList, int end) {
    int lo = 0, hi = rangeList.size()-1, idx = -1;
    // Perform a binary search to find the last range in the rangeList with an end_i value less than or equal to end.
    while (lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if (rangeList.get(mid).getKey() <= end) {
            idx = mid;
            lo = mid+1;
        } else {
            hi = mid-1;
        }
    }
    // If no such range is found, return 0. Otherwise, return the coin value of the range.
    return idx == -1 ? 0 : rangeList.get(idx).getValue();
    }


