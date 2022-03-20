package com.myjava.immutable;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
    public static void main(String[] args) {
//        Car bmw1 = new Car("bmw", new Engine("engine"));
//        Car bmw2 = bmw1;
//        bmw2.changeCarName("bmw2002");
//        bmw2.changeEngine(new Engine("engine2002"));
//
//        System.out.println(bmw1.name + " " + bmw1.engine);
//        System.out.println("bmw1 histories :: " + String.join(",", bmw1.nameHistories));
//        System.out.println(bmw2.name + " " + bmw2.engine);
//        System.out.println("bmw2 histories :: " + String.join(",", bmw2.nameHistories));

        String origin = "hello";
        String copy = origin;
        origin = "bye";
        System.out.println(origin);
        System.out.println(copy);

        int intOrigin = 1;
        int intCopy = intOrigin;
        intOrigin = 2;
        System.out.println(intOrigin);
        System.out.println(intCopy);

        Car carOrigin = new Car("bmw", new Engine("bmwEngine"));
        Car carCopy = carOrigin.clone();
        System.out.println(carOrigin == carCopy);
        carOrigin.changeCarName("bmwNew");
        carOrigin.changeEngine(new Engine("bmwEngineNew"));
        System.out.println(carOrigin);
        System.out.println(carCopy);
    }

    static class Car implements Cloneable {
        private String name;
        private Engine engine;
        private List<String> nameHistories = new ArrayList<>();

        public Car(String name, Engine engine) {
            this.name = name;
            this.engine = engine;
        }

        public void changeCarName(String name) {
            this.nameHistories.add(name);
            this.name = name;
        }

        public void changeEngine(Engine engine) {
            this.engine  = engine;
        }

        @Override
        public Car clone() {
            try {
                return (Car) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", engine=" + engine +
                    ", nameHistories=" + nameHistories +
                    '}';
        }
    }

    static class Engine {
        private String name;

        public Engine(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
