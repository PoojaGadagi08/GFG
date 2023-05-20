

Alice has some cards, each card has one number written on it. She wants to rearrange the cards into groups so that each group is of size groupSize, 
and consists of groupSize consecutive cards.
Given an integer array hand of size N where hand [ i ] is the value written on the ith card and an integer groupSize, return true if she can rearrange 
the cards, or false otherwise.

Example 1:

Input:
N = 9
groupSize = 3
hand[ ] = {1, 2, 3, 6, 2, 3, 4, 7, 8}
Output: true
Explanation: 
Alice's hand can be rearranged as {1, 2, 3} , {2, 3, 4}, {6, 7, 8}. There are three groups with size 3. Each group has 3 consecutive cards.
  
 
  
  
  class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        if(N%groupSize!=0) return false;
        
        TreeMap<Integer,Integer> m=new TreeMap<>();
        
        for(int x: hand){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        
        while(!m.isEmpty()){
            int a=m.firstKey();
            m.put(a,m.get(a)-1);
                    if(m.get(a)==0) m.remove(a);
            for(int j=1;j<groupSize;j++){
                int b=a+j;
                
                if(m.containsKey(b)){
                    m.put(b,m.get(b)-1);
                    if(m.get(b)==0) m.remove(b);
                    
                }
                else return false;
                
            }
             
        }
        return true;
    }
}
