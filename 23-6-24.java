class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int open=1;
        Stack<Integer> st=new Stack();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                st.push(open);
                ans.add(open);
                open++;
                
            }else if(str.charAt(i)==')'){
                ans.add(st.pop());
                
            }
        }
        return ans;
    }
};

