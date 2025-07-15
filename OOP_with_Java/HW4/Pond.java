public class Pond {

    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog peepen = new Frog("Peepen", 11, 13);

        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(12);

        Frog.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        peepo.grow(8);
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        System.out.println(peepo.toString());
        System.out.println(peepen.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }

}