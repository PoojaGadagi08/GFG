// User function Template for Java

// class Solution {
//     int btd(String s){
//         int decimal=0;
//         int n=s.length();
//         int power=0;
//         for(int i=n-1;i>=0;i--){
//             if(s.charAt(i)=='1'){
//                 decimal=decimal+(int)Math.pow(2, power);
//             }
//             power++;
//         }
//         return decimal;
//     }
//     String binaryNextNumber(String s) {
//         // code here.
//         // int decimal=btd(s);
//         // int next=decimal+1;
//         // return Integer.toBinaryString(next);
        
//           int n = s.length();
//         StringBuilder sb = new StringBuilder(s);

//         // Find the rightmost '0' and change it to '1'
//         for (int i = n - 1; i >= 0; i--) {
//             if (sb.charAt(i) == '0') {
//                 sb.setCharAt(i, '1');
//                 // Set all bits to the right of it to '0'
//                 for (int j = i + 1; j < n; j++) {
//                     sb.setCharAt(j, '0');
//                 }
//                 return sb.toString();
//             }
//         }

//         // If no '0' is found, the string is of the form '111...1'
//         // Prepend '1' and set all other bits to '0'
//         sb.insert(0, '1');
//         for (int i = 1; i <= n; i++) {
//             sb.setCharAt(i, '0');
//         }
//         return sb.toString();
//     }
// }



public class Solution {
    public String binaryNextNumber(String s) {
        // Find the first non-zero index
        int firstNonZeroIndex = s.indexOf('1');
        if (firstNonZeroIndex == -1) {
            return "1";
        }
        s = s.substring(firstNonZeroIndex);

        boolean foundZero = false;
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                foundZero = true;
                for (int j = i + 1; j < sb.length(); j++) {
                    sb.setCharAt(j, '0');
                }
                break;
            }
        }
        if (!foundZero) {
            StringBuilder temp = new StringBuilder("1");
            for (int i = 0; i < sb.length(); i++) {
                temp.append('0');
            }
            return temp.toString();
        }
        return sb.toString();
    }
}
