// total subarrays = n(n+1)/2 where n is number of elements in a array
public class SubArrays {
    public static void sub_arrays(int numbers[]) {
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<=numbers.length; j++){
                System.out.print("{ ");
                for (int k=i; k<j ; k++){
                    System.out.print(numbers[k] + " ");
                }
                System.out.print("},");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int numbers[] = {3,4,5,8,9};
        sub_arrays (numbers);
    }
}
