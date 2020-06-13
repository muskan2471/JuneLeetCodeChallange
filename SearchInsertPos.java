/*
 											Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index 
where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0
 */
import java.util.*;
public class SearchInsertPos 
{
	int searchInsert(int[] nums, int target)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            arr.add(nums[i]);
        }
        if(arr.contains(target))
        {
            index=arr.indexOf(target);
        }
        else
        {
            int flag=0;
            int i;
            for(i=0;i<arr.size();i++)
            {
                if(arr.get(i)>target)
                {
                    flag=1;
                    break;
                }
            }
            if(target==0)
            {
                index=0;
            }
            else
            {
                index=i;
            }
            
        }
        return index;
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SearchInsertPos s=new SearchInsertPos();
		int arr[]= {1,3,5,6};
		System.out.print(s.searchInsert(arr, 5));
		

	}

}
