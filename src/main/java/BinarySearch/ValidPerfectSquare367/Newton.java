package BinarySearch.ValidPerfectSquare367;

public class Newton {
    public boolean isPerfectSquare(int num) {
        long guess=num;
        while (guess*guess>num){
            guess=(guess+num/guess)/2;
        }
        return guess*guess==num;
    }
}
