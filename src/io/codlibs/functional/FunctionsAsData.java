package io.codlibs.functional;

import io.codlibs.functional.interfaces.NoArgFunction;



public class FunctionsAsData {

    private record Person(String name, int age) {
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class DataLoader {

        NoArgFunction<FunctionsAsData.Person> loadPerson;

        public DataLoader(boolean isDev) {
            this.loadPerson = isDev ? this::loadRealPerson : this::loadFakePerson;
        }

        private FunctionsAsData.Person loadRealPerson() {
            System.out.println("Loading data...");
            return new Person("Real Person", 50);
        }

        private FunctionsAsData.Person loadFakePerson() {
            System.out.println("Returning Fake Person...");
            return new Person("Fake Person", 100);
        }
    }

    public static void main(String[] args) {
        DataLoader loader = new DataLoader(true);
        System.out.println(loader.loadPerson.apply());
    }
}
