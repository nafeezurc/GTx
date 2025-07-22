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

    public String nextDay(File f) throws FileNotFoundException { // todo
        Scanner fScan = null;

        fScan = new Scanner(f);
        
        Scanner input = new Scanner(System.in);
        String line = null;
        String[] tokens = null;

        while(fScan.hasNextLine()) {
            line = fScan.nextLine();
            tokens = line.split(",");

        }

    }

}