// Binary Tree Traversal in Java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeTraversal {
    // Root node
    Node root;

    // Preorder: Root -> Left -> Right
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder: Left -> Root -> Right
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder: Left -> Right -> Root
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        // Manually constructing the binary tree
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.print("\nInorder: ");
        tree.inorder(tree.root);
        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}
