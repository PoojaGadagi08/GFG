class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer> list  = new ArrayList<>();
        
        int xor = 0;
        
        for(int i = q -1 ; i>=0; i--) {
            if(queries[i][0] == 1) {
                xor ^=queries[i][1];
            }else {
                list.add(queries[i][1] ^xor);
            }
        }
        
        list.add(xor);
        Collections.sort(list);
        return list;
    }
}
