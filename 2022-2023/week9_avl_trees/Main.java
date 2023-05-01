public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        int[] numbers = {43, 18, 22, 9, 21, 6, 8, 20, 63, 50, 62, 51};
        for (int nr : numbers) {
            tree.insert(nr);
        }
        System.out.println(tree);
    }
}
