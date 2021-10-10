package com.techreturners.mars;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MarsRoverControl {
    // get the input using a reader
    // navigate rovers as per the instructions in the input
    // throw errors for invalid moves/input
    // display final MarRoverPos of the rover as output

    public static void main(String[] args) throws IOException {
        //set up  plateau and roverlist
        Plateau plateau;
        String roverPos;
        List<Rover> roverList = new ArrayList<>();
        Rover rovers = new Rover();
        do {
            System.out.println("Input upper-right CoOrds of the Plateau");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine for Upper Grid coordinates
            String[] CoOrds = reader.readLine().split(" ");
            try {
                plateau = new Plateau(Integer.parseInt(CoOrds[0]), Integer.parseInt(CoOrds[1]));
            } catch (Exception e) {
                System.out.println("Invalid Input to Parameter CoOrds for plateau should be positive numbers.");
                continue;
            }

            //Reading data using readLine for rover MarRoverPos and orientation
            System.out.println("Please enter the rover MarRoverPos and orientation");
            String[] roverInVal = reader.readLine().split(" ");
            try {
                rovers = new Rover(Integer.parseInt(roverInVal[0]), Integer.parseInt(roverInVal[1]), String.valueOf(roverInVal[2]));
            } catch (Exception e) {
                System.out.println("Not valid MarRoverPos for Rover.");
                continue;
            }


            //Reading data using readLine for rover Mar Rover Commands
            System.out.println("Please enter commands for the rover");

            // Reading data using readLine
            String roverCmds = reader.readLine().toUpperCase(Locale.ROOT);

            if (!roverCmds.matches("^[MLR]+$")) {
                System.out.println("Invalid  commands.");
                continue;
            }

            try {
                roverPos = rovers.execute(roverCmds);
                System.out.println("Rover Final MarRoverPos" + roverPos);

            } catch (Exception e) {
                System.out.println("Can't execute commands.");
            }

            break;
        } while (true);
    }
}
