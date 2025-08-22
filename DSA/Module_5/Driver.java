public class Driver {
    
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        tree.add(50);
        
        tree.add(15);
        tree.add(75);

        tree.add(5);
        tree.add(25);
        tree.add(100);

        tree.add(10);

        System.out.println("First pass just filling tree: " + tree.toString());
        tree.remove(10);
        tree.remove(25);
        System.out.println("Removing 10 and 25 from tree: " + tree.toString());
        
        tree.add(10);
        System.out.println("Adding 10 back: " + tree.toString());
        tree.remove(5);
        System.out.println("Remove with 1 child case, 5 removed: " + tree.toString());

        tree.remove(10);
        tree.add(5);
        tree.add(25);
        tree.add(20);
        System.out.println("Setting up for 2 child case: " + tree.toString());
        tree.remove(15);
        System.out.println("Removing 15 for 2 child case: " + tree.toString());
    }

}
