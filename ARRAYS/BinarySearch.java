/*The prerequisite for a binary search is that the array
must be Sorted in either ascending or decending order*/
public class BinarySearch {
    public static int Binary_Search(int numbers[],int key){
        int start = 0 , end = numbers.length-1, mid = 0;
        while (start<=end){
            mid = (start + end)/2;
            if (numbers[mid] == key)
                return mid;
            else if (key < numbers[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {1,4,5,7,9,10};
        int key = 10;
        System.out.println("The index is " + Binary_Search(numbers,key));
    }
}
