import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {

    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException {
        day++;
        Scanner fScan = new Scanner(f);
        Scanner input = new Scanner(System.in);
        String line = null;
        String res = "";

        while(fScan.hasNextLine()) {
            line = fScan.nextLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            String species = tokens[1];
            String unique = tokens[2];
            String timeIn = tokens[3];

            if(!(species.equals("Cat") || !(species.equals("Dog")))) {
                throw new InvalidPetException();
            }

            System.out.printf("Consultation for %s the %s at %s.\n\"What is the health of %s?\n", name, species, timeIn, name);

            double health = 0;
            int painLevel = 0;
            boolean validHealth = false;
            boolean validPain = false;
            while(!validHealth) {
                if(input.hasNextDouble()) {
                    health = input.nextDouble();
                    validHealth = true;
                }
                else {
                    input.nextLine();
                    System.out.println("Please enter a number.");
                    System.out.printf("What is the health of %s?\n", name);
                }
            }
            while(!validPain) {
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                if(input.hasNextInt()) {
                    painLevel = input.nextInt();
                    validPain = true;
                }
                else {
                    input.nextLine();
                    System.out.println("Please enter a number.");
                }
            }

            Pet patient;
            if(species.equals("Cat")) {
                patient = new Cat(name, health, painLevel, Integer.parseInt(unique));
            }
            else if(species.equals("Dog")) {
                patient = new Dog(name, health, painLevel, Double.parseDouble(unique));
            }
            health = patient.getHealth(); // constructor will have handled values entered outside of valid range, allowing us to get valid values through getters
            painLevel = patient.getPainLevel();
            patient.speak();
            int treatTime = patient.treat();
            String timeOut = addTime(timeIn, treatTime);
            res += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n", name, species, unique, day, timeIn, timeOut, String.valueOf(health), painLevel);
        }
        fScan.close();
        input.close();
        return res;
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        Scanner fScan = null;
        PrintWriter fPrint = null;
        String res = "";

        try {
            fScan = new Scanner(patientFile);

        } catch (Exception e) {
            return false;
        } finally {
            if(fScan != null) fScan.close();
            if(fPrint != null) fPrint.close();
        }
    }

    private static String addTime(String timeIn, int treatmentTime) {
        int hours = Integer.parseInt(timeIn.substring(0, 2));
        int minutes = Integer.parseInt(timeIn.substring(2));
        hours += (int)((minutes + treatmentTime) / 60);
        minutes = (minutes + treatmentTime) % 60;
        String res = "";
        res += hours < 10 ? "0" + hours : hours;
        res += minutes < 10 ? "0" + minutes : minutes;
        return res;
    }

}