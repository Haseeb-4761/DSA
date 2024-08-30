public class BasicStockMarketing {
    public static int best_price(int prices[]){
        int cp = prices[0], sp = Integer.MIN_VALUE, profit=0 , max_profit=0;
        for (int i=1; i<prices.length; i++){
        //    if (prices[i]>sp)
       //         sp = prices[i];
            sp = prices[i] > sp ? prices[i] : sp ;
  //          if (cp < sp)
    //            profit = sp-cp;
            profit = sp > cp ? sp-cp : profit ;
            max_profit = Math.max(max_profit, profit);
            }
        return max_profit;
        }
// ALTERNATE METHOD
    public static int Best_price(int Prices[]){
        int cp = Integer.MAX_VALUE, profit, max_profit=0;
        for (int i=0; i<Prices.length; i++){
            if (cp < Prices[i]){
                profit = Prices[i]-cp;
                max_profit = Math.max(max_profit, profit);
                }
            else
                cp = Prices[i];
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int prices[] = {2,3,5,1};
        int Prices[] = {2,3,5,1};
        System.out.println("maximum profit is " + best_price(prices));
        System.out.println("maximum profit is " + Best_price(Prices));
    }
}