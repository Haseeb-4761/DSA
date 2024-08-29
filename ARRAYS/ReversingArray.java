public class ReversingArray {
    public static void ReverseArray(int numbers[]) {
        int start=0, end=numbers.length-1, reverse;
        while (start < end){
            reverse = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = reverse;
            start ++;
            end --;
        }
    }
    public static void main(String[] args) {
        int numbers[]={2,3,5,7,8};
        ReverseArray(numbers);
        for (int i=0 ; i<numbers.length ; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
