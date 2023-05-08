// You are given a binary string s and an integer m.
//   You need to return an integer r. Where r = k%m, k is the binary equivalent of string s.

class Solution{
	int modulo(String s, int m) {
// 		//Write your code here
// 		int base=1;
// 		int sum=0;
		
// 		for(int i=s.length()-1;i>=0;i--){
// 		    if(s.charAt(i)=='1'){
// 		         sum+=base;
// 		    }
// 		   base=base*2;
// 		}
// 		return sum%m;

        int base=1;
		int sum=0;
		
		for(int i=s.length()-1;i>=0;i--){
		    if(s.charAt(i)=='1'){
		         sum+=base;
		    }
		    sum%=m;
		   base=base*2;
		   base%=m;
		}
		return sum%m;

        
	}
}
