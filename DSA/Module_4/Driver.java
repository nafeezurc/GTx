public class Driver {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);

        TreeNode<Integer> curr = root;
        
        curr.setLeft(new TreeNode<Integer>(25));
        curr = curr.getLeft();
        curr.setLeft(new TreeNode<Integer>(10));

        curr = root;
        curr.setRight(new TreeNode<Integer>(100));
        curr = curr.getRight();
        curr.setLeft(new TreeNode<Integer>(75));
        curr.setRight(new TreeNode<Integer>(125));
        curr = curr.getRight();
        curr.setLeft(new TreeNode<Integer>(110));

        Traversals<Integer> traverser = new Traversals<>();

        System.out.println(traverser.preorder(root).toString());
        System.out.println(traverser.inorder(root).toString());
        System.out.println(traverser.postorder(root).toString());
    }

}
