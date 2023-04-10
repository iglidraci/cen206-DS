public class TestTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
        Position<Integer> root = binaryTree.addRoot(1);
        Position<Integer> ch1 = binaryTree.addLeft(root, 2);
        Position<Integer> ch2 = binaryTree.addRight(root, 3);
        binaryTree.addLeft(ch1, 4);
        binaryTree.addRight(ch1, 5);
        binaryTree.addLeft(ch2, 6);
        binaryTree.addRight(ch2, 7);
        System.out.println("Inorder: " + binaryTree.inorder());
        System.out.println("Preorder: " + binaryTree.preorder());
        System.out.println("Postorder: " + binaryTree.postorder());
        System.out.println("Breadth-first: " + binaryTree.breadthFirst());
        binaryTree.parentheticRep();
    }
}
