import java.util.Scanner;

public class TemperatureConverter {
    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) { // Ignores capitalization and executes if 'C' is input as a unit
            return temperature = (temperature * 9.0 / 5.0) + 32.0; // returns result from user-input temperature using formula conversion C to F
        }
        else if (unit.equalsIgnoreCase("F")) { // Ignores capitalization and executes if 'F' is input as a unit
            return temperature = (temperature - 32.0) * 5.0 / 9.0; // returns result from user-input temperature using formula conversion F to C
        }
        else {
            return 0.0; // have to return something since we used double in our method signature and not void
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean isRunning = true; // utilizes boolean to show that loop is running (will function as on/off switch)
        while(isRunning) { // while loop is running code below will be executed
            System.out.println("Enter a temperature: (or type 'stop' to quit)"); // prompts user for temperature or to type stop to exit the program
            if (scnr.hasNextDouble()) { // checks and makes sure that the next input put in the scanner is a double
                double temperature = scnr.nextDouble(); // prompts the user to input temperature as a double
                boolean validUnit = false; // makes a variable called validUnit and sets it to false since one hasn't been provided yet
                String unit = ""; // creates an empty string for unit since we need it to be correctly initialized before using it in my loop
                while (!validUnit) { // while unit is invalid code below will be executed
                    System.out.println("Enter unit: 'C' or 'F'"); // prompts the user to enter what unit they are using for the provided temperature
                    unit = scnr.next(); // prompts the user to enter a letter a string to determine which unit the provided temperature was in
                    if (unit.equalsIgnoreCase("C") || (unit.equalsIgnoreCase("F"))) { // makes sure user inputs a valid unit regardless of capitalization
                        validUnit = true; // if 'C' or 'F' is input then validUnit (the boolean value) will be switched to true
                    } else {
                        System.out.println("Error: Invalid unit. Please enter 'C' or 'F'"); // if incorrect input is given then user is prompted to try again and pick 'C' or 'F'
                    }
                }
                double convertedTemp = convertTemperature(temperature, unit); // creates a double variable called convertedTemp to show convertedTemperature for better readability
                if (unit.equalsIgnoreCase("C")) {
                    System.out.println(temperature + "°C is equal to " + convertedTemp + "°F"); // Outputs the conversion from original temperature (Celsius) to converted temperature (Fahrenheit)
                } else {
                    System.out.println(temperature + "°F is equal to " + convertedTemp + "°C"); // Outputs the conversion from original temperature (Fahrenheit) to converted temperature (Celsius)
                }
            }
            else { // if temperature is not a double (number) for input then user must have typed stop or had an incorrect input
                String inputStop = scnr.next(); // creates a string called inputStop to hold 'stop' input for user to type to end program
                if (inputStop.equalsIgnoreCase("stop")) { // if user types 'stop' regardless of capitalization then code below is executed
                    isRunning = false; // loop stops running and program closes
                }
                else { // is user didn't type 'stop' and temperature is not a double (number) then code below must be executed
                    System.out.println("Error: Invalid temperature input. Please enter a number."); // prompts user to provide a double (number) upon incorrect input
                }
            }
        }
        scnr.close(); // closes scanner since we aren't prompting the user for any further inputs
    }
}
