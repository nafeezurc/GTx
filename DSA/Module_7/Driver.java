package DSA.Module_7;

public class Driver {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> map = new ExternalChainingHashMap<>();

        System.out.println("----------Test Case for put()-----------");

        map.put(19, 19);
        map.put(8, 8);
        map.put(11, 11);
        map.put(25, 25);
        map.put(6, 6);

        ExternalChainingMapEntry<Integer, Integer>[] table = map.getTable();
        
        printMap(table);

        map.put(32, 32);
        table = map.getTable();

        printMap(table);

        map.put(12, 12);
        map.put(0, 0);
        map.put(1, 1);
        table = map.getTable();

        printMap(table);

        map.put(12, 13);
        table = map.getTable();

        printMap(table);

        map = new ExternalChainingHashMap<>();
        map.put(4, 4);
        map.put(6, 6);
        map.put(19, 19);
        map.put(8, 8);
        map.put(37, 37);
        map.put(24, 24);
        map.put(11, 11);
        System.out.println("---------Test case for remove()---------");

        table = map.getTable();
        printMap(table);

        map.remove(4);
        map.remove(11);
        map.remove(6);

        table = map.getTable();
        printMap(table);
    }

    public static void printMap(ExternalChainingMapEntry<Integer, Integer>[] table) {
        for(ExternalChainingMapEntry<Integer, Integer> entry : table) {
            if(entry == null) continue;
            int index = entry.getKey().hashCode() % table.length;
            System.out.println("Current index: " + index);
            ExternalChainingMapEntry<Integer, Integer> currNode = entry;
            while(currNode != null) {
                System.out.println(currNode.getKey() + " " + currNode.getValue());
                currNode = currNode.getNext();
            }
        }

        System.out.printf("\nCapacity: " + table.length + "\n");
        System.out.printf("\n-------END--------\n\n");
    }
}