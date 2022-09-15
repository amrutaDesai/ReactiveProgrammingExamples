package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // ReactiveSources.intNumbersFlux().subscribe(number -> System.out.println(number));

        // Like streams flux also returns stream
//        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
//        stream.subscribe(number -> System.out.println(number));

        // How does it behave for multiple calls
        // Its asynchronous so the sequence is not defined, not deterministic
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
        stream.subscribe(number -> System.out.println(number));
        stream.subscribe(number -> System.out.println("Another printing " + number));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
