package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("1. Print all numbers");
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("2. Stream int less than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(i -> System.out.println(i));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("3. Print 2nd & 3rd number which are > 5 ");
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .skip(1)
                .limit(2)
                .forEach(integer -> System.out.println(integer));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("4. find first > 5 else -1");
        Integer value = StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        System.out.println("5. Print Users first name");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));


        // Print first names in userStream for users that have IDs from number stream
        System.out.println("7. Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user1 -> user1.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));

        // Every time a new stream gets created as shown below
        var s1 = StreamSources.intNumbersStream();
        var s2 = s1.flatMap(integer -> StreamSources.userStream().filter(user -> user.getId() == integer));
        s2.forEach(userName -> System.out.println(userName));

        // Better way as User stream could have 0 users in it so lil bit buggy
        System.out.println("Better way of doing it");
        StreamSources.userStream()
                .filter(i -> StreamSources.intNumbersStream().
                        anyMatch(number -> number == i.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));
    }

}
