import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        SinglyLinkedList<String> sSll = new SinglyLinkedList<>();
        sSll.addToBack("0a");
        sSll.removeFromBack();
        System.out.println(sSll.getTail() == null);

        sSll.addToBack("0a");
        sSll.addToBack("1a");
        sSll.addToBack("2a");
        sSll.addToBack("3a");
        sSll.addToBack("4a");
        sSll.addToBack("5a");
        sSll.addToBack("6a");

        String rem = sSll.removeFromBack();
        System.out.println(rem);
        System.out.println(sSll.toString());
        System.out.println(sSll.getTail().getData());

        /*
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        System.out.println("Starting size = " + sll.size());

        sll.addToFront(0);
        System.out.println("Adding 0 to front: " + sll.toString());
        System.out.println("Size = " + sll.size());
        
        sll.addToBack(1);
        System.out.println("Adding 1 to back: " + sll.toString());
        System.out.println("Size = " + sll.size());

        sll.addToBack(2);
        System.out.println("Adding 2 to back: " + sll.toString());
        System.out.println("Size = " + sll.size());

        sll.addToFront(-1);
        System.out.println("Adding -1 to front: " + sll.toString());
        System.out.println("Size = " + sll.size());

        Integer removed = sll.removeFromFront();
        System.out.println("Removing " + removed + " from front: " + sll.toString());
        System.out.println("Size = " + sll.size());

        removed = sll.removeFromBack();
        System.out.println("Removing " + removed + " from back: " + sll.toString());
        System.out.println("Size = " + sll.size());

        sll.removeFromFront();
        sll.removeFromFront();
        System.out.println(sll.getHead() == null);
        System.out.println(sll.getTail() == null);
        sll.addToFront(100);
        System.out.println(sll.getHead() == sll.getTail());
        */
    }

}
