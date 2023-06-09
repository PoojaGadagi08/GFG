Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted order.

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .




class Solution {
   static HashMap<String,Integer> mm;
    static List<String> a;
    static void nikaldo(char ans[]){
        int i=0,j=ans.length-1;
        for(i=ans.length-2;i>=0;i--){
            if(ans[i]<ans[i+1])break;
        }
        if(i<0)return;
        for(int k=ans.length-1;k>i;k--){
            if(ans[k]>ans[i]){
                j=k;
                break;
            }
        }
        char temp=ans[i];
        ans[i]=ans[j];
        ans[j]=temp;
        i++;
        j=ans.length-1;
        while(i<j){
            temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
            i++;
            j--;
        }
        String t = String.valueOf(ans);
        if(mm.get(t)==null)a.add(t);
        mm.putIfAbsent(t,0);
        mm.put(t,mm.get(t)+1);
    }
    public List<String> find_permutation(String S) {
        // Code here
        mm = new HashMap<>();
        a = new ArrayList<>();
        int n = S.length();
        char arr[] = S.toCharArray();
        Arrays.sort(arr);
        a.add(String.valueOf(arr));
        mm.put(String.valueOf(arr),1);
        int k = 1;
        for(int i=2;i<=n;i++)k*=i;
        k--;
        while(k!=0){
        nikaldo(arr);
        k--;
        }
        return a;
    }
    
}
