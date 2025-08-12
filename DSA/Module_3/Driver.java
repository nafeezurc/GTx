import java.util.Arrays;

public class Driver {
    
    public static void main(String[] args) {
        ArrayQueue<Integer> aq1 = new ArrayQueue<>();
        System.out.println("Initial size = " + aq1.size());
        
        aq1.enqueue(0);
        System.out.println("After adding 0: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));

        aq1.enqueue(1);
        aq1.enqueue(2);
        aq1.enqueue(3);
        aq1.enqueue(4);
        aq1.enqueue(5);
        aq1.enqueue(6);
        aq1.enqueue(7);
        aq1.enqueue(8);
        System.out.println("After filling to initial capacity: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));


        /*
        Integer x = aq1.dequeue();
        System.out.println("After removing " + x + " from queue: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));

        aq1.enqueue(9);
        System.out.println("After adding another element post dequeue: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));

        aq1.dequeue();
        System.out.println("After trying dequeue again: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));


        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        System.out.println("After clearing all but one element: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));

        aq1.dequeue();
        System.out.println("After removing the last element: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));

        */
        aq1.enqueue(9);
        System.out.println("After going past initial capacity: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));
        
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        aq1.dequeue();
        System.out.println("Clearing: " + aq1.size());
        System.out.println(Arrays.toString(aq1.getBackingArray()));
        
    }

}
