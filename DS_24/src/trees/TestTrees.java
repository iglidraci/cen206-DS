package trees;

public class TestTrees {
    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> ch1 = tree.addChild(root, 2);
        Position<Integer> ch2 = tree.addChild(root, 3);
        Position<Integer> ch3 = tree.addChild(root, 4);
        tree.addChild(ch1, 5);
        tree.addChild(ch1, 6);
        tree.addChild(ch2, 7);
        tree.addChild(ch2, 8);
        tree.addChild(ch3, 9);
        tree.addChild(ch3, 10);
        System.out.println(tree.preorder().toString());
    }
}
