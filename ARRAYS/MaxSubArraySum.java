public class MaxSubArraySum {
// Brute Force
/*     public static int max_sub_array(int numbers[]){
        int maximum = Integer.MIN_VALUE;
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<=numbers.length; j++){
                int sum = 0; 
                for (int k=i; k<j ; k++){
                    sum += numbers[k];
                }
                if (sum > maximum)
                    maximum = sum;
            }
        }
        return maximum;
    }*/
// prefex array
    public static void max_sub_array1(int numbers1[]){
        int n = numbers1.length;
        int prefix_array[] = new int [n];
        for (int i=0; i<numbers1.length; i++){
            for (int j=0; j<=i; j++){
                prefix_array[i] += numbers1[j];
            }
        }
        for (int i=0; i<prefix_array.length; i++)
            System.out.print(prefix_array[i]+ " ");
    }
    public static void main(String[] args) {
    //    int numbers[] = {1,2,3,4,5};
        int numbers1[] = {1,-2,4,-3,5};
    //    System.out.println("The maximum sub array " + max_sub_array(numbers));
        max_sub_array1(numbers1);
    }
}
