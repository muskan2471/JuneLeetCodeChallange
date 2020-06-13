/*								 Largest Divisible Subset

 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of
 elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
import java.util.*;
public class LargestDivisibleSubset 
{
	List<Integer> largestDivisibleSubset(int[] nums) 
    {
        if(nums==null || nums.length==0)
        {
            return new ArrayList<Integer>();
        }
        
        int dp[]=new int[nums.length];
        
      // we will always have atleast one element divisible by itself 
        Arrays.fill(dp,1);
        
        //Sort all array elements in increasing order. The purpose of sorting is to make sure that all divisors of an element appear before it.
        Arrays.sort(nums);
        
        int max=1;
        int index=0;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                dp[i]=(nums[i] % nums[j]==0)?Math.max(dp[i],dp[j]+1) : dp[i];
                if(dp[i]>max)
                {
                    max=dp[i];
                    index=i;
                }
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        ans.add(nums[index]);
        max--;
        for(int i=index-1;i>=0;i--)
        {
            if(max==dp[i] && nums[index]%nums[i]==0)
            {
                ans.add(nums[i]);
                max--;
            }
        }
        return ans;
        
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LargestDivisibleSubset l=new LargestDivisibleSubset();
		int nums[]= {1,2,4,8};
		List<Integer> ans=l.largestDivisibleSubset(nums);
		

	}

}
