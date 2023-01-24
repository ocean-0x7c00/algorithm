package code.topinterviewquestions;

public class Problem_0104_MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/*
	 * 注意最小高度比这个复杂，要额外小心判断空
	 * */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
