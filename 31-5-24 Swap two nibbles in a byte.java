class Solution {
    static int swapNibbles(int N) {
        // code here
        
        return (((N&15)<<4) | ((N&240)>>4));
    }
}
