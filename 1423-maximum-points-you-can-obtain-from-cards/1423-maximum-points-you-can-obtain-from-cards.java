class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int n=cardPoints.length;
       //calc sum of first k cards
       int total=0;
       for(int i=0;i<k;i++){
        total+= cardPoints[i];
       }
       //store maxmimum score;
       int maxPoints=total;

       //slide the window: remove from front and add from back
       for(int i=0;i<k;i++){
        //subtract card from front;
        total -= cardPoints[k-1-i];
        //add from back
        total += cardPoints[n-1-i];

        maxPoints= Math.max(maxPoints,total);
       }
       return maxPoints;
    }
}