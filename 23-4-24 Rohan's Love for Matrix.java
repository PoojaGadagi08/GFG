class Solution {
  public:
    int firstElement(int n) {
        int a=0,b=1;
        int mod=1e9+7;
        while(n--){
            int c=(a+b)%mod;
            a=b%mod;
            b=c%mod;
        }
        return a;
    }
};
