package sdf;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        //prints welcome message
        System.out.println("Welcome.");

        //console object to read input from command line
        Console console = System.console(); 
        //empty string to store numbers within input
        String input = "";
        //declares variables
        double no1; 
        double no2; 
        double last; 

        //while loop required as the program will keep on looping until user keys in quit
        while (!((input.equalsIgnoreCase("exit")) )) {
            //continuously prompt the user to enter command
            input = console.readLine("What operation would you like to perform? Type 'help' for more instructions. \n");

            //help function 
            if (input.equalsIgnoreCase("help")) {
                System.out.println("<number> + <number> to perform addition");
                System.out.println("<number> - <number> to perform subtraction");
                System.out.println("<number> / <number> to perform division");
                System.out.println("<number> * <number> to perform multiplication");
                System.out.println("$last +/-///* <number> to perform operation on the previous result");
                System.out.println("'exit' to quit the calculator program \n\n");
            }
            
            //declares string array for input to be split into individual elements
            String[] inputArr = input.split(" ");


            if (input.contains("+")){
                no1 = Double.parseDouble(inputArr[0]);
                no2 = Double.parseDouble(inputArr[2]);
                last = no1 + no2; 
                System.out.println(last);
                
                if (input.startsWith("$last +")) {
                no1 = last;
                no2 = Double.parseDouble(inputArr[2]);
                last = no1 + no2;
                System.out.println(last);
            }
            }

            
            
            
            if (input.contains("-")){
                no1 = Double.parseDouble(inputArr[0]);
                no2 = Double.parseDouble(inputArr[2]);
                last = no1 - no2; 
                System.out.println(last);
            }

            if (input.contains("/")){
                no1 = Double.parseDouble(inputArr[0]);
                no2 = Double.parseDouble(inputArr[2]);
                last = no1 / no2; 
                System.out.println(last);
            } 
            
            if (input.contains("*")){
                no1 = Double.parseDouble(inputArr[0]);
                no2 = Double.parseDouble(inputArr[2]);
                last = no1 * no2; 
                System.out.println(last);
            }
            

            } 
            

        //if they key in exit
        if (input.equalsIgnoreCase("exit")){
            System.out.println("Bye bye");
            System.exit(0);
        }

        
}

    }
    
