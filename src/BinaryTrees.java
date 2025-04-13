import java.util.*;
import java.util.LinkedList;

public class BinaryTrees
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree
    {
        static int indx = -1;

        static class Info
        {
            int diameter;
            int height;

            Info(int diameter, int height)
            {
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static Node buildTree(int[] nodes) //O(n)
        {
            indx++;

            if(nodes[indx] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) //O(n)
        {
            if(root == null)
            {
                System.out.print("-1 ");
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) //O(n)
        {
            if(root == null)
            {
                System.out.print("-1 ");
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " "); 
            inorder(root.right);
        }

        public static void postorder(Node root) //O(n)
        {
            if(root == null)
            {
                System.out.print("-1 ");
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " "); 
        }

        public static void levelOrder(Node root)
        {
            if(root == null)
            {
                return;
            }

            Queue<Node> que = new LinkedList<>();
            que.add(root);
            que.add(null);

            while(!que.isEmpty())
            {
                Node currNode = que.remove();

                if(currNode == null)
                {
                    System.out.println();

                    if(que.isEmpty())
                    {
                        break;
                    }
                    else
                    {
                        que.add(null);
                    }
                }
                else
                {
                    System.out.print(currNode.data + " ");

                    if(currNode.left != null)
                    {
                        que.add(currNode.left);
                    }

                    if(currNode.right != null)
                    {
                        que.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root)
        {
            if(root == null)
            {
                return 0;
            }

            int lHeight = height(root.left);
            int rHeight = height(root.right);
            
            return Math.max(lHeight, rHeight) + 1;
        }

        public static int countNodes(Node root)
        {
            if(root == null)
            {
                return 0;
            }

            int lCount = countNodes(root.left);
            int rCount = countNodes(root.right);

            return lCount + rCount + 1;
        }

        public static int nodeSum(Node root)
        {
            if(root == null)
            {
                return 0;
            }

            int lSum = nodeSum(root.left);
            int rSum = nodeSum(root.right);

            return lSum + rSum + root.data;
        }

        public static int diameter(Node root) //O(n^2)
        {
            if(root == null)
            {
                return 0;
            }

            int lDiam = diameter(root.left);
            int rDiam = diameter(root.right);
            int lHeight = height(root.left);
            int rHeight = height(root.right);
            
            int selfDiam = lHeight + rHeight + 1;

            return Math.max(selfDiam, Math.max(lDiam, rDiam));
        }

        public static Info diameterEffi(Node root) //O(n)
        {
            if(root == null)
            {
                return new Info(0, 0);
            }

            Info lInfo = diameterEffi(root.left);
            Info rInfo = diameterEffi(root.right);

            int diam = Math.max((lInfo.height + rInfo.height + 1), Math.max(lInfo.diameter, rInfo.diameter));
            int ht = Math.max(lInfo.height, rInfo.height) + 1;

            return new Info(diam, ht);
        }

        public static boolean isSubtree(Node root, Node subRoot)
        {
            if(root == null)
            {
                return false;
            }

            if(root.data == subRoot.data)
            {
                if(isIdentical(root, subRoot))
                {
                   return true;
                }
            }

            return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);
        }

        public static boolean isIdentical(Node node, Node subRoot)
        {
            if(node == null && subRoot == null)
            {
                return true;
            }
            else if(node == null || subRoot == null || node.data != subRoot.data)
            {
                return false;
            }

            if(!isIdentical(node.left, subRoot.left))
            {
                return false;
            }

            if(!isIdentical(node.right, subRoot.right))
            {
                return false;
            }

            return true;
        }
    }


    public static void main(String[] args)
    {
        /*

                1
               / \
              2   3
             /   / \
            4   5   6
               /
              7

        */

        int[] nodes1 = {1, 2, 4, -1, -1, -1, 3, 5, 7, -1, -1, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes1);
        // System.out.println(root.data);
        // tree.postorder(root);
        // System.out.println();
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.nodeSum(root));
        System.out.println(tree.diameterEffi(root).diameter);

        int[] nodes2 = {3, 5, 7, -1, -1, -1, 6, -1, -1};
        Node subroot = tree.buildTree(nodes2);
        // Node subroot = new Node(3);
        // subroot.left = new Node(5);
        // subroot.left.left = new Node(7);
        // subroot.right = new Node(6);
        System.out.println(tree.isIdentical(root, subroot));
    }
}