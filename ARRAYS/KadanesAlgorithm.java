/* + + = +
   ++  - = +
   +  -- = - >>> assume equal to zero
 */
public class KadanesAlgorithm {
    public static int kad_algo(int numbers[]){
        int sum=0 , max = Integer.MIN_VALUE;
        for (int i=0 ; i<numbers.length; i++){
            sum += numbers[i];
            if (sum<0)
                sum = 0;
            max = Math.max(max,sum);      
        }
        return max;
    }
    public static void main(String[] args) {
        int numbers[] = {1,-2,5,-3,4,6,-5};
        System.out.println("The maximum sub array sum is " + kad_algo(numbers));
    }
}
