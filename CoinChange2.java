/*					Coin Change 2


You are given coins of different denominations and a total amount of money. Write a function 
to compute the number of combinations that make up that amount. You may assume that you have
infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1


Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.


Example 3:
Input: amount = 10, coins = [10] 
Output: 1
*/

/*
            Time Complexity : 2^n
Base Cases:
if amount=0 then just return empty set to make the change, so 1 way to make the change.
if no coins given, 0 ways to change the amount.


Rest of the cases:
For every coin we have an option to include it in solution or exclude it.
check if the coin value is less than or equal to the amount needed, if yes then we will find ways by including that coin and excluding that coin.
Include the coin: reduce the amount by coin value and use the sub problem solution (amount-v[i]).
Exclude the coin: solution for the same amount without considering that coin.
If coin value is greater than the amount then we can’t consider that coin, so solution will be without considering that coin.
*/
public class CoinChange2
{
	 int change(int amount, int[] coins)
	    {
	       int table[][]=new int[coins.length+1][amount+1];
	       
	        // if amount=0 then just return empty set to make the change
	        for(int i=0;i<table.length;i++)
	        {
	            table[i][0]=1;
	        }
	        
	        // if no coins given, 0 ways to change the amount
	        for(int i=1;i<table[0].length;i++)
	        {
	            table[0][i]=0;
	        }
	        
	        //rest of fil/ with 
	        for(int i=1;i<table.length;i++)  //here coins[i] is value of coin
	        {
	            for(int j=1;j<table[0].length;j++)  //j is coins needed tomanke amount
	            {
	                //ckeck coin value is less than amount needed
	                if(coins[i-1]<=j)
	                {
	                    //          use solution of subproblem + reduce the amount by coin 
	                    table[i][j]=table[i-1][j] + table[i][j-coins[i-1]];
	                }
	                else
	                {
	                    table[i][j]=table[i-1][j];
	                }
	            }
	        }
	        return table[table.length-1][amount];
	    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int coins[]= {1,2,3};
		CoinChange2 c=new CoinChange2();
		System.out.println(c.change(5, coins));
	}

}
