






class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        int ans=-1;
         HashMap<Integer,Integer> hs =new HashMap<>();
        for(int i=0;i<n;i++){
         if(!hs.containsKey(a[i])){
             hs.put(a[i],1);
             if(hs.get(a[i])==k) return a[i];
         } else{
             hs.put(a[i],hs.get(a[i])+1);
             if(hs.get(a[i])==k) return a[i];
         }
     }return -1;
        
    } 
}
