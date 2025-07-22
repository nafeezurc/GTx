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

            System.out.printf("Consultation for %s the %s at %s.\n", name, species, timeIn);

        }
    }

}