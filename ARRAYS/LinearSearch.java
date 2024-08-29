// largest and smallest number in an array
public class LinearSearch {
    public static int largest (int numbers[]){
        int largest = Integer.MIN_VALUE;
        for (int i=0 ; i<numbers.length; i++){
            if (numbers[i]>largest)
                largest = numbers[i];
            }
        return largest;
    }
    public static int smallest (int numbers[]){
        int smallest = Integer.MAX_VALUE;
        for (int i=0 ; i<numbers.length; i++){
            if (numbers[i]<smallest)
                smallest = numbers[i];
            }
        return smallest;
    }
    public static void main(String[] args) {
        int numbers[] = {1,5,3,8,9,3,4,2};
        System.out.println("The largest number in the array is " + largest(numbers));
        System.out.println("The smallest number in the array is " + smallest(numbers));
    }
}