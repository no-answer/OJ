package LeetCode;

public class _108 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return splite(nums, 0, nums.length-1);
    }

    private TreeNode splite(int [] nums, int left, int right) {
        if (left+1 == right) {
            TreeNode rightNode = new TreeNode(nums[right]);
            TreeNode leftNode = new TreeNode(nums[left]);
            rightNode.left = leftNode;
            return rightNode;
        }
        else if (left == right) {
            TreeNode Node = new TreeNode(nums[right]);
            return Node;
        }
        int mid = (left+right)/2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = splite(nums, left, mid-1);
        midNode.right = splite(nums, mid+1, right);
        return midNode;
    }
}
