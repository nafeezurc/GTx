public class Bad2 {
    public static void main(String[] args) {
        int a = 1331;
        int b = 1; // can't divide by 0, so change it to some other value, 1 in this case
        System.out.println("Welcome to \nCS 1331!");
        int c = a / b; 
        System.out.println("c is equal to: " + c);
    }
}