package io.codlibs.functional.interfaces;

import java.util.function.Function;

public class ReturningFunctions {

    private static class MyMath {
        int timesTwo(int x) {
            return x * 2;
        }
        int timesThree(int x) {
            return x * 3;
        }
        int timesFour(int x) {
            return x * 4;
        }

        static Function<Integer, Integer> createMultiplier(int y) {
            return (x) -> x * y;
        }
    }


    public static void main(String[] args) {
        Function<String, NoArgFunction<String>> greeter = (x) -> {
            x = "Hello " + x;
            String finalX = x;
            return () -> finalX + ", How are you doing?";
        };

        System.out.println(greeter.apply("Manoj").apply());

        NoArgFunction<NoArgFunction<String>> greet = () -> () -> "Hello Functional!";
        System.out.println(greet.apply().apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
        System.out.println(timesTwo.apply(6));
        System.out.println(timesThree.apply(6));

    }
}
