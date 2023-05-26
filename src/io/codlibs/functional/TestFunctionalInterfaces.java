package io.codlibs.functional;

import io.codlibs.functional.interfaces.*;

import java.util.Random;
import java.util.function.Function;
import java.util.function.BiFunction;

public class TestFunctionalInterfaces {

    private static class MyMath {
        public static Integer triple(Integer x) {
            return x * x * x;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> triplet = MyMath::triple;
        System.out.println(triplet.apply(5));

        Function<Integer, Integer> trip = (x) -> x * x * x;
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(2,3));
        TriFunction<Integer, Integer, Integer, Integer> add3 = (x, y, z) -> x + y + z;
        QuadFunction<Integer, Integer, Integer, Integer, Integer> mul = (v, x, y, z) -> v * x * y * z;
        NoArgFunction<Boolean> random = () -> new Random().nextBoolean();
        NoReturnFunction<String> sayHello = (x) -> System.out.println("Hello " + x);

        final int x = 10000;
        NoArgNoReturnFunction sleep10Sec = () -> {
            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.println(trip.apply(3));
        System.out.println(add3.apply(1,2,3));
        System.out.println(mul.apply(1,2,3,4));
        System.out.println(random.apply());
        sayHello.apply("Manoj");
        sleep10Sec.apply();
        sayHello.apply("Manoj Sharma");
    }
}
