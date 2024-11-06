
import java.util.Scanner;

public class knapsack01 {
    
    /*public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        
        // Store the result of Knapsack
        int result = dp[n][capacity];
        
        // Find the items that were included in the knapsack
        System.out.println("Selected items:");
        int w = capacity;
        for (int i = n; i > 0 && result > 0; i--) {
            if (result != dp[i - 1][w]) {
                System.out.println("Item " + i + " (Weight: " + weights[i - 1] + ", Value: " + values[i - 1] + ")");
                result -= values[i - 1];
                w -= weights[i - 1];
            }
        }
        
        // Return the maximum value we can get
        return dp[n][capacity];
    }*/



    /*Recurssion */

    /*public static int knapsack(int[] weights, int[] values, int capacity,int index) {
        if(index==0) {
            if(weights[index]<=capacity)return values[index];
            else return 0;
        }

        int nonTake = knapsack(weights, values, capacity, index-1);
        int take = Integer.MIN_VALUE;

        if(weights[index]<=capacity) {
             take = values[index] + knapsack(weights, values, capacity-weights[index], index-1);
        }

        return Math.max(nonTake, take);
    }*/


    /* Memoization  */

    /*public static int knapsack(int[] weights, int[] values, int capacity,int index,int[][] dp) {
        if(index==0) {
            if(weights[index]<=capacity)return values[index];
            else return 0;
        }

        if(dp[index][capacity]!=-1) return dp[index][capacity];

        int nonTake = knapsack(weights, values, capacity, index-1,dp);
        int take = values[index] + knapsack(weights, values, capacity-weights[index], index-1,dp);

        return dp[index][capacity] =  Math.max(nonTake, take);
    }*/

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many items : ");
        int n = scanner.nextInt();

        int[] values =new int[n];
        int[] weights = new int[n];

        System.out.println("-----------");

        System.out.print("How much capacity : ");
        int capacity = scanner.nextInt();

        System.out.println("------------");

        for(int i=0;i<n;i++){
            System.out.print("Enter weight : ");
            int weight = scanner.nextInt();
            System.out.print("Enter value : ");
            int value = scanner.nextInt();

            weights[i] = weight;
            values[i] = value;
            System.out.println("---------");
        }

        scanner.close();




        //for(int[] row:dp)             // For memoization
        //    Arrays.fill(row, -1);
        
        //int maxValue = knapsack(weights, values, capacity,2);     // For Recurssion

        //int maxValue = knapsack(weights, values, capacity,2,dp);     //For Memoization




        // Tabulation
        /* int[][] dp = new int[n][capacity+1];
        for(int w=weights[0];w<=capacity;w++){
            dp[0][w] = values[0];
        }

        for(int id=1;id<n;id++){
            for(int w=0;w<=capacity;w++){
                int nonTake = dp[id-1][w];
                int take = Integer.MIN_VALUE;
                if(weights[id]<=w){
                    take = values[id] + dp[id-1][w-weights[id]];
                }
                dp[id][w] = Math.max(nonTake, take);
            }
        }
        
        System.out.println("Maximum value: " + dp[n-1][capacity]);
        */


        // Space Optimization
        int[] prev = new int[capacity+1];
        int[] curr = new int[capacity+1];

        for(int w=weights[0];w<=capacity;w++){
            prev[w] = values[0];
        }

        for(int id=1;id<n;id++){
            for(int w=0;w<=capacity;w++){
                int nonTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(weights[id]<=w){
                    take = values[id] + prev[w-weights[id]];
                }
                curr[w] = Math.max(nonTake, take);
            }
            prev = curr;
        }
        System.out.println("Maximum value: " + prev[capacity]);

    }
}
