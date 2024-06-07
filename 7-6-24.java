  int[] count = new int[maxx + 2]; // +2 to handle the end + 1 index safely
        
        // Applying the increment and decrement logic
        for (int i = 0; i < l.length; i++) {
            count[l[i]]++;
            if (r[i] + 1 <= maxx) {
                count[r[i] + 1]--;
            }
        }
        
        // Calculating the prefix sum to find actual coverage counts
        int maxCount = 0;
        int maxOccurringInt = 0;
        int currentCount = 0;
        
        for (int i = 0; i <= maxx; i++) {
            currentCount += count[i];
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxOccurringInt = i;
            }
        }
        
        return maxOccurringInt;
