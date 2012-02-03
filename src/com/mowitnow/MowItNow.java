package com.mowitnow;

import com.mowitnow.environment.Gardener;

import java.io.FileNotFoundException;

/**
 * Main class starting mowers by the gardener with an indicated specification file
 */
public class MowItNow {

    public static void main(String args[]) {
        if (args.length > 0) {
            try {
                //Gardener starts to mow area
                new Gardener(args[0]).mow();
            } catch (FileNotFoundException e) {
                System.err.println("Sorry, where's the specification file again ? Gardener needs it in order to work !");
            }
        } else {
            System.err.println("Sorry, you haven't indicate your absolute path file in program parameters. \n" +
                               "For instance : java MowItNow c:/orders.txt");
        }
        System.exit(0);
    }


}
