package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

/**
 * Flux metaphor  - series of item over time
 * Stream (collection stream) metaphor - series of items all at a time(all available at once)
 */
public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size

        /**
         * example of Blocking the flux
         */
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("List " + numbers);
        System.out.println("List size " + numbers.size());

        // it is fine that we could remove waiting time here
        // the code is blocked as sout will not execute until numbers are populated in numbers variable
       /* System.out.println("Press a key to end");
        System.in.read();*/
    }
}
