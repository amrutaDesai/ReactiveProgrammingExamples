package io.javabrains.reactiveworkshop;

import java.io.IOException;

/**
 * Reactive core is a dependency for reactive programming it's not java core
 * Flux - asynchronous sequence of items,  0 OR N items
 * mono - asynchronous sequence of 0 OR 1 item, 1 item that may or may not come in future 0 OR 1 item
 * <p>
 * Flux - back pressure - if publishers is publishing too fast that subscriber does not have ability to
 * process it then it has an opportunity to tell publisher please send it a bit slow for me to process it.
 * <p>
 * Analogy to understand,  just a note flux is a publisher, emits items / events
 * <p>
 */
public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        /**
         * Example of blocking the mono
         * It tells to block(wait) until it gets a value
         * blocking is not good thing because we lose the benefit of reactive programming
         */
        Integer number = ReactiveSources.intNumberMono().block();
        //System.out.println(number);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
