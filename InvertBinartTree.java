/*
 Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

import java.util.*;
class TreeNode 
{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right)
      {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }
public class InvertBinartTree 
{
	public TreeNode invertTree(TreeNode root) 
    {
        
        if(root==null)
        {
            return null;
        }
        else
        {
            //TreeNode invertTreeRoot=new TreeNode(root.val);
           // TreeNode current=invertTreeRoot;
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty())
            {
                TreeNode removed=q.remove();
                if(removed.left!=null && removed.right!=null)
                {
                    TreeNode left=removed.left;
                    removed.left=removed.right;
                    removed.right=left;
                }
                else if(removed.left!=null && removed.right==null)
                {
                    TreeNode left=removed.left;
                    removed.left=null;
                    removed.right=left;
                }
                else if(removed.right!=null && removed.left==null)
                {
                    TreeNode right=removed.right;
                    removed.right=null;
                    removed.left=right;
                }
                
                if(removed!=null)
                {
                     if(removed.left!=null)
                    {
                        q.add(removed.left);
                    }
                    if(removed.right!=null)
                    {
                        q.add(removed.right);
                    }
                }
               
            }
            return root;
        }
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right=new TreeNode(7);
		root.right.right=new TreeNode(9);
		root.right.left=new TreeNode(6);
		InvertBinartTree i=new InvertBinartTree();
		TreeNode invertRoot=i.invertTree(root);
		 Queue<TreeNode> q=new LinkedList<>();
         q.add(invertRoot);
         while(!q.isEmpty())
         {
        	 TreeNode removed=q.remove();
        	 System.out.print(removed.val+" ");
        	 if(removed.left!=null)
             {
                 q.add(removed.left);
             }
             if(removed.right!=null)
             {
                 q.add(removed.right);
             }
         }


	}

}
