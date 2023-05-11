// Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter.
//   Now if it is possible to make the string S a palindrome after replacing all '?' then find the palindromic 
// string with a minimum ascii sum of the absolute difference of adjacent characters. Otherwise, return -1.

class Solution {
     public static int minimumSum(String s) {
        // code here
    int length = s.length(); // get the length of the input string
    int left = 0; // initialize the left index
    int right = length - 1; // initialize the right index
    char[] arr = s.toCharArray(); // convert the input string to a character array

    // Checking for validity
    while (left <= right) {
        if (arr[left] != arr[right] && arr[left] != '?' && arr[right] != '?') {
            // if the characters at the left and right indices are different and neither is a '?', return -1
            return -1;
        }

        left++; // move the left index to the right
        right--; // move the right index to the left
    }

    left = 0; // reset the left index
    right = length - 1; // reset the right index
    StringBuilder str = new StringBuilder();
    while (left <= right) {
        if (arr[left] != '?') {
            // if the character at the left index is not a '?', append it to the new string
            str.append(arr[left]);
        } else if (arr[right] != '?') {
            // if the character at the right index is not a '?', append it to the new string
            str.append(arr[right]);
        }

        left++; // move the left index to the right
        right--; // move the right index to the left
    }

    int result = 0; // initialize the result
    for (int i = 1; i < str.length(); i++) {
        // iterate through the new string and calculate the sum of differences between adjacent characters
        result += 2 * (Math.abs(str.charAt(i) - str.charAt(i - 1)));
        // multiply by 2 since each difference is counted twice (once for each adjacent pair of characters)
    }

    return result; // return the result
    }


}
