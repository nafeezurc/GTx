public class Gameplay {
    
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        liam.sabotage(bob);

        liam.sabotage(susPerson);

        liam.freeze(albert);

        albert.emergencyMeeting();
        susPerson.emergencyMeeting();

        bob.emergencyMeeting();

        heath.completeTask();

        heath.completeTask();

        heath.completeTask();

        liam.freeze(angel);

        liam.sabotage(bob);

        liam.sabotage(bob);

        liam.freeze(bob);

        //angel.emergencyMeeting();

        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.freeze(heath);
    }

}