Given a string s of lowercase English characters, find out whether the summation of x and y is even or odd, where x is the count of distinct 
  characters that occupy even positions in English alphabets and have even frequency, y is the count of distinct characters which occupy odd positions in English alphabets and have odd frequency.
Note: Positive means greater than zero.


  class Solution {
    public static String oddEven(String s) {
        // code here
        int hash[]= new int[26];
        int x=0;
        int y=0;
        for(char ch : s.toCharArray()){
            hash[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            int freq=hash[i];
            if(freq>0){
                int pos=i+1;
                if(freq%2 ==0){
                    if(pos%2 ==0 ) x++;
                }
                else {
                    if(pos%2 !=0) y++;
                }
            }
        }
        
        int sum=x+y;
        return (sum%2==0)?"EVEN":"ODD";
    }
}
