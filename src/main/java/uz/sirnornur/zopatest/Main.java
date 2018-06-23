package uz.sirnornur.zopatest;

import uz.sirnornur.zopatest.service.Solution;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide all arguments.");
            return;
        }
        String filename = args[0];
        Integer requestedAmount = Integer.parseInt(args[1]);

        try {
            new Solution(filename, requestedAmount).run();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.out.println("It is not possible to provide a quote at this time.");
        }
    }

}
