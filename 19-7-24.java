class Solution {

    double maxVolume(double perimeter, double area) {
        double P = perimeter;
        double A = area;
        
        // Compute intermediate terms to find dimensions
        double sqrtTerm = Math.sqrt(P * P - 24 * A);
        double dimension1 = (P - sqrtTerm) / 12.0;
        double dimension2 = (P / 4.0) - 2 * dimension1;
        
        // Calculate the volume
        double volume = Math.pow(dimension1, 2) * dimension2;
        
        // Round the result to two decimal places
        return Math.round(volume * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

}

}

