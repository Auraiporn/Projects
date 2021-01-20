import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.LinkedList;

public class convertSortedListToBinarySearchTree {
    /**
     * Definition for singly-linked list. */
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * Definition for a binary tree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // List sorted in ascending order 1,2,3,4,5,6,7
    /***
     *          4
     *       /   \
     *      2     6
     *    /  \   / \
     *   1   3  5   7
     */

    public TreeNode sortedListToBST(ListNode head) {
        return buildBinarySearchTree(head, null);
    }

    /**
     * A method to construct a binary serch tree.
     * @param head a head node of a linked list
     * @param tail indicates the end of a linked list
     * */
    public TreeNode buildBinarySearchTree(ListNode head, ListNode tail){
        if(head == tail) return null;
        // Use two pointers to find the middle element of the linked list
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer!=tail && fastPointer.next!= tail){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // Do a recusive call to construct the tree
        TreeNode root = new TreeNode(slowPointer.val);
        root.left = buildBinarySearchTree(head, slowPointer);
        root.right = buildBinarySearchTree(slowPointer.next, tail);
        return root;
    }

}
