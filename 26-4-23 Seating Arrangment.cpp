// You are given an integer n, denoting the number of people who needs to be seated, 
// and a list of m integers seats, where 0 represents a vacant seat and 1 represents an already occupied seat.

// Find whether all n people can find a seat, provided that no two people can sit next to each other.




class Solution{
    public:
    bool is_possible_to_get_seats(int n, int m, vector<int> &seats)
{
    int count = 0;
    for (int i = 0; i < m; i++)
    {
        bool left = false, right = false;
        if (i == 0 || seats[i - 1] == 0)
            left = true;
        if (i == m - 1 || seats[i + 1] == 0)
            right = true;
        if (seats[i] == 0 && left && right)
        {
            count++;
            seats[i] = 1;
        }
    }
    return count >= n;
}

};
