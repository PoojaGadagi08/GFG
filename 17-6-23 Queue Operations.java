Given N integers, the task is to insert those elements in the queue. Also, given M integers, the task is to find the frequency of each number in the Queue.
Note:

insert() will be called N times by main().
findFrequency() will be called M times by main();
Where k is each element passing through respective function calls.
Example 1:

Input:
N = 8
1 2 3 4 5 2 3 1
M = 5
1 3 2 9 10
Output:
2
2
2
-1
-1
Explanation:
After inserting 1, 2, 3, 4, 5, 2, 3 and 1 into the queue, frequency of 1 is 2, 3 is 2 and 2 is 2. Since 9 and 10 are not there in the queue we output -1 for them.
  
  
  
  // Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks{
    
   static HashMap<Integer,Integer> mm;
    static boolean a=false;
    static void insert(Queue<Integer> q, int k){
        
        // Your code here
        if(a==false){
            mm=new HashMap<>();
            a=true;
        }
        q.add(k);
        mm.putIfAbsent(k,0);
        mm.put(k,mm.get(k)+1);
    }
    
    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        
        // Your code here
        a=false;
        if(mm.get(k)==null)return 0;
        return mm.get(k);
    }
    
}
