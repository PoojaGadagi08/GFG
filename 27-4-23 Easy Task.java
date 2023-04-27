// Q.Given a string s whose length is n and array queries of length q where each elements of queries 
// is either of type 1 query or type 2 query which is explained ahead.

// There are two types of query.

// Query type 1 : ["1",ind,char]  "1" denotes this is type 1 query. In this query you have to change the character at 
// index ind in s to character char.(Data type of ind,char is string in input)

// Query Type 2: ["2",left,right,k]  "2" denotes this is type 2 query. In this query you have to return kth lexographically 
// largest character  in the subtring of s (it is the kth largest character in sorted order , not the kth distinct character) starting 
// from index left and ending at index right both left and right are inclusive. (Data type of left,right,k is string in input)

// You have to perform each query in the same order as given in  queries and return an array res such that res array 
// contains the answer for each type2 query in same order as it appeared in queries.

// Note : 0 based indexing is used.



class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        // Create a character array from the input string
        char[] charArray = s.toCharArray();
        // Initialize an array list to store the results of type 2 queries
        ArrayList<Character> res = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            query currQuery = queries[i];
            String type = currQuery.type;
            if (type.equals("1")) {
                // Type 1 query
                int index = Integer.parseInt(currQuery.a);
                char character = currQuery.b.charAt(0);
                charArray[index] = character;
            } else {
                // Type 2 query
                int left = Integer.parseInt(currQuery.a);
                int right = Integer.parseInt(currQuery.b);
                int k = Integer.parseInt(currQuery.c);

                // Create a frequency array to count the occurrence of each character
                int[] freq = new int[26];
                for (int j = left; j <= right; j++) {
                    freq[charArray[j] - 'a']++;
                }

                // Find the kth largest character by iterating over the frequency array
                int count = 0;
                for (int j = 25; j >= 0; j--) {
                    count += freq[j];
                    if (count >= k) {
                        res.add((char) ('a' + j));
                        break;
                    }
                }
            }
        }

        return res;
    }


}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
