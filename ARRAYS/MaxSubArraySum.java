public class MaxSubArraySum {
// Brute Force
    public static int max_sub_array(int numbers[]){
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
    }
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5};
        System.out.println("The maximum sub array " + max_sub_array(numbers));
    }
}
