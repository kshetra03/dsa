package ctci.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // left - root - right
    public void InOrderTraverse(final TreeNode root) {
        if (root == null) return;
        InOrderTraverse(root.left);
        System.out.print(root.val + " ");
        InOrderTraverse(root.right);
    }

    // root -- left -- right
    public void PreOrderTraversal(final TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    // left -- right -- root
    public void PostOrderTraversal(final TreeNode root) {
        if (root == null) return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);

        System.out.print(root.val + " ");
    }

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        for (int i=0; i<treeHeight(root); i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel(TreeNode node, int level) {
        if (node == null) return;
        if (level == 0) {
            System.out.print(node.val + " ");
        }
        else if (level > 0) {
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    public int treeHeight(final TreeNode root) {
        if (root == null)  return 0;
        int lHeight = treeHeight(root.left);
        int rHeight = treeHeight(root.right);
        return Math.max(lHeight + 1, rHeight + 1);
    }

    public void levelOrderTraversal_Iterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // to know where to print new line
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.val + " ");
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    // find level of a Node
    public int getLevelOfNode(TreeNode root, int val) {
        if (root == null) return -1;

        int lvl = 0;
        if (root.val == val) return lvl;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); q.add(null);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    lvl += 1;
                }
            } else {
                if (curr.val == val)
                    return lvl;

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(16);
        root.left.left =  new TreeNode(8);
        root.left.right =  new TreeNode(12);

        root.right.right =  new TreeNode(18);

        MyTree myTree = new MyTree();
        System.out.println("InOrder Traversal");
        myTree.InOrderTraverse(root);
        System.out.println();

        System.out.println("PreOrder Traversal");
        myTree.PreOrderTraversal(root);
        System.out.println();

        System.out.println("PostOrder Traversal");
        myTree.PostOrderTraversal(root);
        System.out.println();

        System.out.println("Level Order Traversal");
        myTree.levelOrderTraversal(root);
        System.out.println();

        System.out.println("Level Order Traversal -- Iterative");
        myTree.levelOrderTraversal_Iterative(root);
        System.out.println();

        System.out.println("Level of Node with Val " + 12 + ": " + myTree.getLevelOfNode(root, 12));
    }
}
