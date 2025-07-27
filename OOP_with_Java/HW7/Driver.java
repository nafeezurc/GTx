public class Driver {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("isEmpty: " + ll.isEmpty());
        ll.add(1);
        System.out.println("isEmpty: " + ll.isEmpty());
        ll.add(2);
        ll.add(3);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        System.out.println("contains 2: " + ll.contains(2));
        System.out.println("contains 4: " + ll.contains(4));
        ll.add(1, 0);
        System.out.println(ll.toString());
        System.out.println("get @ 1: " + ll.get(1));
        System.out.println("get @ 2: " + ll.get(2));
        System.out.println("indexOf 1: " + ll.indexOf(1));
        System.out.println("indexOf 0: " + ll.indexOf(0));
        System.out.println("indexOf 2: " + ll.indexOf(2));
        System.out.println("indexOf 3: " + ll.indexOf(3));
        ll.set(1, 4);
        System.out.println(ll.toString());
        ll.add(0, 0);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        ll.set(0, 9);
        System.out.println(ll.toString());
        ll.remove(0);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        ll.remove(1);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        Integer val0 = 1;
        Integer val1 = 2;
        Integer val2 = 3;
        ll.remove(val1);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        ll.remove(val2);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        ll.remove(val0);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());

        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        System.out.println("isEmpty: " + ll.isEmpty());
        ll.clear();
        System.out.println(ll.toString());
        System.out.println("size: " + ll.size());
        System.out.println("isEmpty: " + ll.isEmpty());
    }

}