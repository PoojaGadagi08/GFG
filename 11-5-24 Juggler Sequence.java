import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> jugglerSequence(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(n); // Add the initial value of n to the list
        while(n != 1) {
            if (n % 2 == 0)
                n = (int) Math.pow(n, 0.5); // Square root for even numbers
            else
                n = (int) Math.pow(n, 1.5); // Cube root for odd numbers
            ans.add(n); // Add the next value of n to the list
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> sequence = jugglerSequence(9); // Example: Generate Juggler Sequence starting from 9
        System.out.println(sequence);
    }
}
