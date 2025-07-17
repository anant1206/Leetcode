class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int h1 = Math.abs(ay1-ay2) , h2 = Math.abs(by1-by2);
        int b1 = Math.abs(ax1-ax2) , b2 = Math.abs(bx1-bx2);
        
        int area1 = b1 * h1;
        int area2 = b2 * h2;
        // To find the left side of the overlapping box, You take the larger of the two left sides.
        // Why? Because the overlap can’t start before both rectangles have started. 

        // To find the right side of the overlap, You take the smaller of the two right sides.
        // Why? Because the overlap can’t go past where one of the rectangles ends.
        
        int leftX = Math.max(ax1, bx1); 
        int rightX = Math.min(ax2, bx2); 
        int bottomY = Math.max(ay1, by1); 
        int topY = Math.min(ay2, by2); 
        
        int width = rightX - leftX; 
        int height = topY - bottomY; 

        if (width < 0 || height < 0) {  
            return area1 + area2;  
        } else {   
        return area1 + area2 - width * height; 
        } 
    }
}