package com.myjava.immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTest {

    public static void main(String[] args) {
        List<Car> carNames = new ArrayList<>();
        carNames.add(new Car("hodol"));
        Cars cars = new Cars(carNames);

        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }

        System.out.println(cars);

        carNames.add(new Car("pobi"));
        System.out.println(cars);

        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
    }
}
