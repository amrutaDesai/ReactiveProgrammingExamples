package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

/**
 * What's coming from mono/flux
 * 1. item to be processed
 * 2. complete event (termination event) nothing can come after this
 * 3.a failure event (termination event because nothing can come after this)
 * <p>
 * su
 */
public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()
        /*

         */
/**
 * Subscribe to a flux using the error and completion hooks
 *
 *//*

        ReactiveSources.intNumberMono()
                .subscribe(number -> System.out.println(number),
                        (err -> System.out.println(err.getMessage())),
                        () -> System.out.println("Complete"));
        */
/**
 * calling subscriber with exception
 *//*


        ReactiveSources.intNumbersFluxWithException()
                .subscribe(number -> System.out.println(number),
                        e -> System.out.println(e.getMessage()),
                        () -> System.out.println("Complete"));
*/


        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber());
        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        /**
         * Backpressure - need to request how many items this subscription can handle may be 1/10
         * Ok to push 1 more , here it's not a pulling/pushing mechanism explicitly
         * its ok to push 1 more but not more than that for now
         */
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }

}