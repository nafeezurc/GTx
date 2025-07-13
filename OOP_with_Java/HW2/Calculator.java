import java.util.Scanner;

/*
For homework 02, you will be creating a calculator that can perform the following operations: add, subtract, multiply, divide, and alphabetize. The operations work as follows:

    add - takes two integers, adds them together and prints out the result
    subtract - takes two integers, subtracts the second entered integer from the first and prints out the result
    multiply - takes two doubles, multiplies them together and prints out the result to two decimal places
    divide - takes two doubles, divides the first entered double by the second and prints out the result to two decimal places
    alphabetize - takes two words (without spaces) and tells which word comes before the other lexicographically
*/

public class Calculator {
    public static void main(String[] args) {

        System.out.printf("List of operations: add subtract multiply divide alphabetize\nEnter an operation:\n");
        Scanner input = new Scanner(System.in);

        String operation = input.nextLine();

        boolean valid = true;

        switch(operation.toLowerCase()) { // use switch statement to prompt for input types

            case "add":
                System.out.println("Enter two integers:");
                int addend1;
                int addend2;
                if(input.hasNextInt()) { // check to see if valid input type first
                    addend1 = input.nextInt();
                    if(input.hasNextInt()) { // check if second input is valid too
                        addend2 = input.nextInt();
                    }
                    else {
                        valid = false; // mark invalid and leave switch statement if invalid
                        break;
                    }
                }
                else {
                    valid = false;
                    break;
                }
                System.out.println("Answer: " + (addend1 + addend2));
                break;

            case "subtract":
                System.out.println("Enter two integers:");
                int minuend;
                int subtrahend;
                if(input.hasNextInt()) {
                    minuend = input.nextInt();
                    if(input.hasNextInt()) {
                        subtrahend = input.nextInt();
                    }
                    else {
                        valid = false;
                        break;
                    }
                }
                else {
                    valid = false;
                    break;
                }
                System.out.println("Answer: " + (minuend - subtrahend));
                break;

            case "multiply":
                System.out.println("Enter two doubles:");
                double factor1;
                double factor2;
                if(input.hasNextDouble()) factor1 = input.nextDouble(); // make sure a double is entered
                else {
                    valid = false; // invalid if not
                    break;
                }
                if(input.hasNextDouble()) factor2 = input.nextDouble();
                else {
                    valid = false;
                    break;
                }
                System.out.printf("Answer: %.2f\n", (factor1 * factor2));
                break;

            case "divide":
                System.out.println("Enter two doubles:");
                double dividend;
                double divisor;
                if(input.hasNextDouble()) dividend = input.nextDouble();
                else {
                    valid = false;
                    break;
                }
                if(input.hasNextDouble()) divisor = input.nextDouble();
                else {
                    valid = false;
                    break;
                }
                if(divisor == 0) { // can't divide by 0, mark invalid
                    valid = false;
                    break;
                }
                System.out.printf("Answer: %.2f\n", (dividend / divisor));
                break;

            case "alphabetize":
                System.out.println("Enter two words:");
                String word1;
                String word2;
                if(input.hasNext()) word1 = input.next(); // makes sure there's a string first
                else {
                    valid = false;
                    break;
                }
                if(input.hasNext()) word2 = input.next();
                else {
                    valid = false;
                    break;
                }
                if(word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) 
                    System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                else if(word1.toLowerCase().compareTo(word2.toLowerCase()) < 0) 
                    System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                else 
                    System.out.println("Answer: Chicken or Egg.");
                break;

            default:
                valid = false;
        }

        if(valid == false) { // if valid is ever false, print invalid input message
            System.out.println("Invalid input entered. Terminating...");
        }

        input.close();

    }

}