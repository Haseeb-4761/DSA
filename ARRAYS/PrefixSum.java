// sum in range [2,5] = prefix-sum[0,5] - prefix-sum[0,1]
public class PrefixSum {
    public static int prefix_sum(int numbers[]) {
        int prefix_sum[] = new int [numbers.length];
        int sum = 0 , max = Integer.MIN_VALUE;
        prefix_sum[0] = numbers[0];
        for (int i=1; i<numbers.length; i++){
            prefix_sum[i] = prefix_sum[i-1] + numbers[i];
        }
        for (int i=0; i<prefix_sum.length; i++){
            for (int j=i; j<prefix_sum.length; j++){
                sum = i==0 ? prefix_sum[j] : prefix_sum[j]-prefix_sum[i-1];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int numbers[] = {1,-3,4,-2,6,-1};
        System.out.print("The maximum sub array sum is " + prefix_sum(numbers));
    }
}
