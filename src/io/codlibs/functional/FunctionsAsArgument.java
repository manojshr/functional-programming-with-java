package io.codlibs.functional;

import java.util.function.BiFunction;

public class FunctionsAsArgument {

    private static class MyMath {
        static int min(int x, int y) {
            return Math.min(x, y);
        }
        static int max(int x, int y) {
            return Math.max(x, y);
        }

        public static int eval(int x, int y, BiFunction<Integer, Integer, Integer> combinator) {
            return combinator.apply(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println(MyMath.eval(2, 3, MyMath::min));
        System.out.println(MyMath.eval(2, 3, MyMath::max));
        System.out.println(MyMath.eval(3, 4, (x, y) -> x * y));
    }
}
