
// Geek is organizing a birthday party, so his friends brought a cake for him. The cake consists of N chunks, 
// whose individual sweetness is represented by the sweetness array. Now at the time of distribution, Geek cuts the cake into K + 1 pieces to distribute among his
// K friends. One piece he took for himself. Each piece consists of some consecutive chunks. He is very kind, so he left the piece with minimum sweetness for him.

// You need to find the maximum sweetness that the Geek can get if he distributes the cake optimally.



class Solution{
	boolean isPoss(int [] sweetness, int mid, int k) {
	    int sum = 0;
	    int cnt = 0;
	    
	    for (int i = 0; i < sweetness.length; i++) 
	    {
	        sum += sweetness[i];
	        if (sum >= mid) {
	            cnt++;
	            sum = 0;
	        }
	    }
	    return cnt >= k + 1;
	}
	int maxSweetness(int [] sweetness, int n, int k) {
	    int sum = 0;
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++)
	    {
	        sum += sweetness[i];
	        min = Math.min(min, sweetness[i]);
	    }
	    
	    int l = min;
	    int h = sum;
	    int ans = 0;
	    
	    while (l <= h) {
	        int mid = (l+ h) / 2;
	        if (isPoss(sweetness, mid, k)) 
	        {
	            ans = mid;
	            l = mid + 1;
	        } else {
	            h = mid - 1;
	        }
	       // System.out.print(l + " " + h);
	       //   System.out.println();
	    }
	    
	    return ans;
	}


}
