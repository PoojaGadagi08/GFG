Given a dictionary of words where each word follows CamelCase notation, print all words (in lexicographical order) in the dictionary that match with a given
pattern consisting of uppercase characters only.

Example: GeeksForGeeks matches the pattern "GFG", because if we combine all the capital letters in GeeksForGeeks they become GFG.

CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. Common examples include
PowerPoint and Wikipedia, GeeksForGeeks, CodeBlocks, etc.

Example 1:

Input:
N=3
Dictionary=["WelcomeGeek",
"WelcomeToGeeksForGeeks","GeeksForGeeks"]
Pattern="WTG"
Output:
WelcomeToGeeksForGeeks
Explanation:
Since only WelcomeToGeeksForGeeks matches 
the pattern, it is the only answer.


class Solution{
    ArrayList<String> ans = new ArrayList<>();
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
       //make root node , build and find pattern
        trie root=new trie();
        build(Dictionary,root);
        find(Pattern,root);
        
        //asked by question to reurn in lexo order
        Collections.sort(ans);
        if(ans.isEmpty()) ans.add("-1");
        return ans;
    }
    public void build(String a[], trie root){
        trie temp=null;
        for(int i = 0;i < a.length;i++){
            temp = root;
            for(int j = 0;j < a[i].length();j++){
                if(Character.isUpperCase(a[i].charAt(j))){
                    //if next node DNE make a new one and point to it
                if(temp.ch[a[i].charAt(j)-'A'] == null)
                    temp.ch[a[i].charAt(j)-'A'] = new trie();
                temp = temp.ch[a[i].charAt(j)-'A'];
                }
            }
            //aftre building the trie for Upper case letters , add the string at end
            temp.al.add(a[i]);
        }
    }
    public int find(String s, trie root){
        for(int i = 0;i < s.length();i++){
            //if at any point the whole pattern isnot present in trie return 0;
            if(root.ch[s.charAt(i)-'A'] == null)
            return 0;
            root = root.ch[s.charAt(i)-'A'];
        }
        printAllWords(root);
        return 1;
    }
    
    void printAllWords(trie root) {
        //add all the strings ass and do the same for its child.
        for (String str : root.al) ans.add(str);
        for (int i = 0; i < 26; i++) {
            trie child = root.ch[i];
            if (child!=null) printAllWords(child);
        }
    }
    public class trie
    {
        trie ch[];
        ArrayList<String> al ;
        public trie()
        {
            ch=new trie[26];
            for(int i=0;i<26;i++){
                ch[i]=null;
            }
            al =new ArrayList<>();
        }
    }
}
