package com.algorithm.kth;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class provides a method to find the k-th largest level sum in a binary tree.
 *
 * @author lesion
 */
public class KthLargestLevelSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            pq.offer(levelSum);
        }

        if (pq.size() < k) return -1;

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.poll();

    }

    public static void main(String[] args) {
        KthLargestLevelSum kthLargestLevelSum = new KthLargestLevelSum();
        TreeNode root = kthLargestLevelSum.new TreeNode(1);
        root.left = kthLargestLevelSum.new TreeNode(7);
        root.right = kthLargestLevelSum.new TreeNode(0);
        root.left.left = kthLargestLevelSum.new TreeNode(7);
        root.left.right = kthLargestLevelSum.new TreeNode(-8);

        System.out.printf("The 4th largest level sum is: %d\n", kthLargestLevelSum.kthLargestLevelSum(root, 4));
    }
}
