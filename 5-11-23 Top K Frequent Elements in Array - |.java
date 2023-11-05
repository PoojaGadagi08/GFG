Given a non-empty array nums[] of integers of length N, find the top k elements which have the highest frequency in the array. If two numbers have same frequencies, then the larger number should be given more preference.

Example 1:

Input:
N = 6
nums = {1,1,1,2,2,3}
k = 2
Output: {1, 2}
Example 2:

Input:
N = 8
nums = {1,1,2,2,3,3,3,4}
k = 2
Output: {3, 2}
Explanation: Elements 1 and 2 have the
same frequency ie. 2. Therefore, in this
case, the answer includes the element 2
as 2 > 1.
User Task:
You don't have to read or print anything. You will have to complete the function topK() that takes an array nums[] and integer k as input and returns a list of top k most frequent elements. If any two elements have same frequencies, then give more preference to the larger elemet.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 105
1<= nums[i] <=105
1 <= k <= N



  class Solution {
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) { //N
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( //min heap by default
        //and we cannot use max heap since we wan top k largest
            (a, b) -> {//CUSTOM COMPARATOR
                if (!a.getValue().equals(b.getValue())) {
                    return a.getValue() - b.getValue(); //  frequency in asc
                } else {
                    return a.getKey() - b.getKey(); // if freq same, sort by key in asc
                }
            }
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//N
            pq.add(entry);
            if(pq.size()>k)//logK
            pq.poll();
         
        }
    //  while(!pq.isEmpty()){
    //  System.out.println(pq.poll());
    //  }
        
        int[] ans = new int[k];
        int idx=k-1;
        while(!pq.isEmpty())
        {
            ans[idx--]=pq.poll().getKey();
        }
      return ans;

    }
}
