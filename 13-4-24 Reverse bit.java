

class Solution {
    static Long reversedBits(Long x) {
        // code here
        String s=Long.toBinaryString(x);
        
        while(s.length()<32)s="0"+s;
        s=new StringBuilder(s).reverse().toString();
        return Long.parseLong(s,2);
    }
};

.
