import java.util.LinkedList;
import java.util.Queue;

public class buildAndTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;

        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int arr[]) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node n = new Node(arr[idx]);
            n.left = buildTree(arr);
            n.right = buildTree(arr);
            return n;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);

                    }
                } else {
                    System.out.println(currNode.data);
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

            }
        }

        public static int hieght(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = hieght(root.left);
            int rh = hieght(root.right);
            int currHieght = Math.max(lh, rh) + 1;
            return currHieght;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int lcount = count(root.left);
            int rcount = count(root.right);
            int currcount = lcount + rcount + 1;
            return currcount;
        }

        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int lsum = sum(root.left);
            int rsum = sum(root.right);
            int currsum = lsum + rsum + root.data;
            return currsum;
        }

        public static int diameter1(Node root) {
            if (root == null) {
                return 0;

            }
            int leftDia = diameter1(root.left);
            int rightDia = diameter1(root.right);
            int leftHieght = hieght(root.left);
            int rightHeight = hieght(root.right);
            int seldia = leftHieght + rightHeight + 1;
            return Math.max(seldia, Math.max(rightDia, leftDia));
        }

        public static class Info {
            int dia;
            int h;

            Info(int dia, int h) {
                this.dia = dia;
                this.h = h;
            }

        }

        public static Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);

            }
            Info lInfo = diameter2(root.left);
            Info rInfo = diameter2(root.right);
            int currDia = Math.max(lInfo.h + rInfo.h + 1, Math.max(lInfo.dia, rInfo.dia));
            int currh = Math.max(lInfo.h, rInfo.h) + 1;
            return new Info(currDia, currh);
        }

        public static boolean isSubTree(Node tree, Node subtree) {
            if (tree == null) {
                return false;
            }
            if (tree.data == subtree.data) {
                if (isIdentical(tree, subtree)) {
                    return true;
                }
            }

            boolean leftSubtree = isSubTree(tree.left, subtree);
            boolean rightSubtree = isSubTree(tree.right, subtree);

            return leftSubtree || rightSubtree;
        }

        public static boolean isIdentical(Node tree, Node subtree) {
            if (tree == null && subtree == null) {
                return true;
            } else if (tree == null || subtree == null || tree.data != subtree.data) {
                return false;
            }

            if (!isIdentical(tree.left, subtree.left)) {
                return false;
            }
            if (!isIdentical(tree.right, subtree.right)) {
                return false;
            }
            return true;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree b = new BinaryTree();
        Node n = b.buildTree(arr);
        // System.out.println(n.left.data);
        // System.out.println("pre");
        // b.preOrder(n);
        // System.out.println("inorder");

        // b.inOrder(n);

        // System.out.println("post");
        // b.postOrder(n);
        // System.out.println("level order ");
        // b.levelOrder(n);

        // int hieght = b.hieght(n);
        // System.out.println(hieght);
        // int count = b.count(n);
        // System.out.println(count);
        // int sum = b.sum(n);
        // System.out.println(sum);

        // int dia = b.diameter1(n);
        // System.out.println(dia);

        // System.out.println( b.diameter2(n).dia);

        // defining new subtree
        Node n1 = new Node(2);
        n1.left = new Node(4);
        n1.right = new Node(5);

        System.out.println(b.isSubTree(n, n1));

    }
}
