// You are given a 2D integer array of intervals whose length is n where intervals[i]=[start, end] I.e. 
//   all integers from start to end inclusive of start and end are also present and also we are given an integer k. 
//   We have to return the Powerfull Integer. A powerful Integer is an integer that occurs at least k times. If multiple integers have at least k occurrences, 
// we have to return the maximum integer out of all those elements. 

// Note: If no integer occurs at least k times return -1.


class Solution{
    public static int powerfullInteger(int n,int in[][],int k)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
             map.put(in[i][0], map.getOrDefault(in[i][0],0)+1);
              map.put(in[i][1]+1, map.getOrDefault(in[i][1]+1,0)-1);
        }
        int p_s=0;
        int ans=0;
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            int x = e.getKey(); int y = e.getValue();
          
            if(y>=0)
            {
                  p_s+=y;
                if(p_s>=k) ans=x;
            }
            else if(y<0) 
            {
                if(p_s>=k) ans=x-1;
                   p_s+=y;  // trick here
            }
            
        }
        return ans>0 ? ans:-1;
       
    }
}
