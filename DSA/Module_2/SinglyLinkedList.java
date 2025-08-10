// import java.util.Arrays; // Purely using this for testing in Driver class, library not allowed for this assignment
import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Data cannot be null");
        if(head == null) { // if list is empty
            head = new SinglyLinkedListNode<T>(data, null);
            tail = head;
        }
        else{
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data, head);
            if(head.getNext() == null) { // if the initial size was 1 and we add to front, the old head becomes the new tail
                tail = head;
            }
            head = newNode;
        }    
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Data cannot be null");
        if(head == null) { // if list is empty
            head = new SinglyLinkedListNode<T>(data, null);
            tail = head;
        }
        else{
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(head == null) throw new NoSuchElementException("List is empty");
        T data = head.getData();
        head = head.getNext();
        if(head == null || head.getNext() == null) { // if the head is null or is the only node left, then tail is also head
            tail = head;
        }
        size--;
        return data;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(head == null) throw new NoSuchElementException("List is empty");
        T data = null;
        if(head.getNext() == null) {
            data = head.getData();
            head = null;
            tail = null; // empty, so tail points to the null as well
        }
        else {
            SinglyLinkedListNode<T> curr = head;
            while(curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            tail = curr;
            data = curr.getNext().getData();
            curr.setNext(null);
        }
        size--;
        return data;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /*
    // DELETE BEFORE SUBMITTING - purely used for testing in Driver class
    @SuppressWarnings("unchecked")
    public String toString() {
        if(size == 0) return null;
        SinglyLinkedListNode<T> curr = head;
        T[] res = (T[]) new Object[size];
        for(int i = 0; i < size; i++) {
            res[i] = curr.getData();
            curr = curr.getNext();
        }
        return Arrays.toString(res);
    }
    */

}