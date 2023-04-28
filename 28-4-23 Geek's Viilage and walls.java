// Geek's village is represented by a 2-D matrix of characters of size n*m, where

// H - Represents a house
// W - Represents a well
// . - Represents an open ground
// N - Prohibited area(Not allowed to enter this area)

// Every house in the village needs to take water from a well, as the family members are so busy with their work,
// so every family wants to take the water from a well in minimum time, which is possible only if they have to cover as less 
// distance as possible. Your task is to determine the minimum distance that a person in the house should travel to take out the water and carry it back to the house.

// A person is allowed to move only in four directions left, right, up, and down. That means if he/she is the cell (i,j), then
// the possible cells he/she can reach in one move are (i,j-1),(i,j+1),(i-1,j),(i+1,j), and the person is not allowed to move out of the grid.

// Note: For all the cells containing 'N', 'W' and '.' our answer should be 0, and for all the houses where there is no 
// possibility of taking water our answer should be -1.



class pair
    {
        int a,b,c;
         pair(int a,int b,int c)
        {
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
//User function Template for Java
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int res[][]=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(res[i],Integer.MAX_VALUE);
        

        boolean v[][]=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(c[i][j]=='W'){
                    v[i][j]=true;
                    res[i][j]=0;
                    q.add(new pair(i,j,0));  // these are all the points from where bfs has to start
                }
            }
        }

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(!q.isEmpty())
              {
            pair p=q.poll();
            for(int i=0;i<4;i++) //move in all 4 dir
            {
                int new_x=p.a+dx[i]; int new_y=p.b+dy[i];
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<m && !v[new_x][new_y] && c[new_x][new_y]!='N'){
                    q.add(new pair(new_x,new_y,p.c+1));
                    v[new_x][new_y]=true;
                    res[new_x][new_y]=p.c+1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='.' || c[i][j]=='N')
                    res[i][j]=0;
               
                else if(res[i][j]==Integer.MAX_VALUE)
                    res[i][j]=-1;
                else
                    res[i][j]*=2;
                
            }
        }

        return res;
    }
   
}
