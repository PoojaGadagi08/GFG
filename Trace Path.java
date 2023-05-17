

// There is a rectangular path for a Train to travel consisting of n rows and m columns. 
//The train will start from one of the grid's cells and it will be given a command in the form of string s consisting of characters L, R, D, U. 
//Find if it is possible to travel the train inside the grid only.
// Note:
// If the train is at position (i,j)
// on taking 'L' it goes to (i,j-1),
// on taking 'R' it goes to (i,j+1),
// on taking 'D' it goes to (i-1,j),
// on taking 'U' it goes to (i+1,j).


//java
//Brute force

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        // int t_l =  0; int t_r= 0; int t_u =0; int t_d=0;// max consecutive l,r,ud
        // int f_lr =0; int f_ud=0;0
        for(int i =0; i<n ;i++)
        {
            for(int j=0; j<m; j++)
            {
                int x=i; int y=j;
                for(int k = 0;k < s.length();k++)
                {
                    if(s.charAt(k) == 'L')
                        y-=1;
                    else if(s.charAt(k) == 'R')
                       y+=1;
                    else if(s.charAt(k) == 'U')
                        x+=1;
                    else
                        x-=1;
                     
                     if(x<0 || x>=n || y<0 || y>=m)
                     break;
                }
            if(x>=0 && x<n && y>=0 && y<m)
            return 1;
            
            }
        }
        return 0;
    }
}

//optimized
class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        int t_l =  0; int t_r= 0; int t_u =0; int t_d=0;// max consecutive l,r,ud
        int f_lr =0; int f_ud=0;
            for(int i = 0;i < s.length();i++){
        if(s.charAt(i) == 'L')
                f_lr++;
            else if(s.charAt(i) == 'R')
                f_lr--;
            else if(s.charAt(i) == 'U')
                f_ud++;
            else
                f_ud--;
                
                if(f_lr>=0) //more left than right
                t_l = Math.max(t_l, f_lr);
                else
                t_r = Math.min(t_r, f_lr);
                
                if(f_ud>=0) t_u = Math.max(t_u, f_ud);
                else t_d =Math.min(t_d, f_ud);
            }
        if(t_l-t_r<m && t_u-t_d<n)
        return 1;
        
        return 0;
    }
}
