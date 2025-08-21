public class Driver {
    
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        tree.add(50);
        
        tree.add(15);
        tree.add(75);

        tree.add(5);
        tree.add(25);
        tree.add(100);

        tree.add(20);

        tree.remove(15);

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> parent = root;
        BSTNode<Integer> left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        BSTNode<Integer> right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Root: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        /*
        System.out.printf("Root: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        tree.add(5);
        tree.add(25);
        tree.add(100);

        // left subtree first
        parent = left;
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        tree.add(10);
        parent = left;
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        tree.remove(10);
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        tree.add(10);
        tree.remove(5);
        parent = root.getLeft();
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        tree.add(5);
        tree.remove(10);
        tree.add(20);
        tree.remove(15);
        parent = root.getLeft();
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");
        */

        //right subtree second
        parent = root.getRight();
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");

        parent = right;
        left = parent.getLeft() != null ? parent.getLeft() : new BSTNode<Integer>(-1000000000);
        right = parent.getRight() != null ? parent.getRight() : new BSTNode<Integer>(-1000000000);

        System.out.printf("Parent: " + parent.getData() + "\nLeft: " + left.getData() + "\nRight: " + right.getData() + "\n\n");
    }

}
