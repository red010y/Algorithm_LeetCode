package BinarySearch.ValidPerfectSquare367;

public class BinarySearch {
    public boolean isPerfectSquare(int num) {
        long left=0;
        long right=num;
        while (right>=left){
            long mid=(right+left)/2;
            if (mid*mid==num)return true;
            else if (mid*mid<num){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }
}
