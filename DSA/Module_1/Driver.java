import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Integer> custom = new ArrayList<>();
        System.out.println(custom.size());
        custom.addToFront(1);
        custom.addToFront(0);
        custom.addToBack(2);
        System.out.println(Arrays.toString(custom.getBackingArray()));
        Integer x = custom.removeFromFront();
        System.out.println(Arrays.toString(custom.getBackingArray()));
        System.out.println(x);
        x = custom.removeFromBack();
        System.out.println(x);
        System.out.println(Arrays.toString(custom.getBackingArray()));
        System.out.println(custom.size());
        x = custom.removeFromBack();
        System.out.println(custom.size());
        for(int i = 0; i < 9; i++) {
            custom.addToBack(i);
        }
        System.out.println(custom.size());
        System.out.println(Arrays.toString(custom.getBackingArray()));
        custom.addToFront(-1);
        custom.addToBack(9);
        System.out.println(Arrays.toString(custom.getBackingArray()));
        System.out.println(custom.size());
    }
}
