public class TrappingRainWater {
    public static int trapping_rainwater(int numbers[]) {
        int n = numbers.length, water_level=0,water_trapped=0,total_water_trapped=0;
        int left_max[] = new int [n];
        int right_max[] = new int [n];
        for (int i=0; i<n; i++){
            left_max[i] = i==0 ? numbers[i] : Math.max(numbers[i],left_max[i-1]);
            }
        for (int i=n-1; i>=0; i--){
                right_max[i] = i==(n-1) ? numbers[n-1] : Math.max(numbers[i], right_max[i+1]);
            }
        for (int i=0; i<n; i++){
            water_level = Math.min(left_max[i],right_max[i]);
            water_trapped = water_level-numbers[i];
            total_water_trapped += water_trapped;
        }
        return total_water_trapped;
    }
    public static void main(String[] args) {
        int numbers[] = {4,6,2,5,8,5,9};
        System.out.print("total water trapped " + trapping_rainwater(numbers));
    }
}
