class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        
        for(char nut : nuts)list1.add(nut);
        for(char bolt : bolts)list2.add(bolt);
        
        List<Character> pattern = Arrays.asList('!', '#', '$', '%', '&', '*', '?', '@', '^');
        
        int indx = 0;
        
        for(int i=0; i<pattern.size(); i++){
            if(list1.contains(pattern.get(i)) && list2.contains(pattern.get(i))){
                nuts[indx] = pattern.get(i);
                bolts[indx] = pattern.get(i);
                indx++;
            }
        }

        
    }
}

.
