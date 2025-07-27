public class LinkedList<E> {

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(int index, E element) {
        if(isEmpty()) {
            head = new Node<E>(element, null);
            size++;
            return;
        }
        if(index == 0) {
            head = new Node<E>(element, head);
            size++;
            return;
        }
        Node<E> cur = head;
        while(index > 1) {
            if(cur.next == null) {
                throw new IndexOutOfBoundsException();
            }
            cur = cur.next;
            index--;
        }
        cur.next = new Node<E>(element, cur.next);
        size++;
    }

    public void add(E element) {
        add(size, element);
    }

    public boolean contains(Object o) {
        if(isEmpty()) return false;
        //if(!(o instanceof E)) return false;

        boolean found = false;
        Node<E> cur = head;
        while(cur != null && !found) {
            if(o.equals(cur.data)) {
                found = true;
            }
            else {
                cur = cur.next;
            }
        }
        return found;
    }

    public E get(int index) {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        Node<E> cur = head;
        while(index > 0) {
            if(cur.next == null) {
                throw new IndexOutOfBoundsException();
            }
            cur = cur.next;
            index--;
        }
        return cur.data; 
    }

    public int indexOf(Object o) {
        if(isEmpty()) return -1;
        //if(!(o instanceof E)) return -1;
        int index = 0;
        Node<E> cur = head;
        while(cur != null) {
            if(o.equals(cur.data)) {
                return index;
            }
            else {
                index++;
                cur = cur.next;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        if(index == 0) {
            E res = head.data;
            head = head.next;
            size--;
            return res;
        }
        Node<E> cur = head;
        
        while(index > 1) {
            if(cur.next == null) {
                throw new IndexOutOfBoundsException();
            }
            cur = cur.next;
            index--;
        }
        E res = cur.next.data;
        cur.next = cur.next.next;
        size--;
        return res;
    }

    public boolean remove(Object o) {
        if(isEmpty()) return false;
        //if(!(o instanceof E)) return false;
        if(o.equals(head.data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> cur = head;
        while(cur.next != null) {
            if(o.equals(cur.next.data)) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E set(int index, E element) {
        if(isEmpty()) throw new IndexOutOfBoundsException();

        Node<E> cur = head;
        while(index > 0) {
            if(cur.next == null) {
                throw new IndexOutOfBoundsException();
            }
            cur = cur.next;
            index--;
        }
        E res = cur.data;
        cur.data = element;
        return res;
    }

    public String toString() {
        if(isEmpty()) return "[]";
        if(head.next == null) return "[" + String.valueOf(head.data) + "]";

        String res = "[" + String.valueOf(head.data);
        Node<E> cur = head.next;

        while(cur != null) {
            res += ", " + String.valueOf(cur.data);
            cur = cur.next;
        }

        res += "]";
        return res;
    }

    public boolean equals(Object o) { // maybe attempt later
        return true;
    }

}