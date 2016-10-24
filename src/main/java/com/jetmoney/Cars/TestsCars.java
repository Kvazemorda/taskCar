package com.jetmoney.Cars;

import com.jetmoney.Entity.CarEntity;

import java.util.ArrayList;

public class TestsCars {
    public TestsCars() {

        CarEntity carEntity1 = new CarEntity("o323ye24", "Toyota");
        CarEntity carEntity2 = new CarEntity("o426ye24", "Mazda 3");
        CarEntity carEntity3 = new CarEntity("o526ye24", "Lada Priora");
        CarEntity carEntity4 = new CarEntity("o328ye24", "Suzuki");
        CarEntity carEntity5 = new CarEntity("o363ye24", "Lada Kakina");
        CarEntity carEntity6 = new CarEntity("o329ye24", "Mazda 5");
        CarEntity carEntity7 = new CarEntity("o340ye24", "BMV 6");
        CarEntity carEntity8 = new CarEntity("o358ye24", "Gelendvagen");
        CarEntity carEntity9 = new CarEntity("o843ye24", "Toyota Yuris");
        CarEntity carEntity10 = new CarEntity("o384ye24", "Toyota LandeCruser");
        CarEntity carEntity11 = new CarEntity("o325ye24", "Volga");
        CarEntity carEntity12 = new CarEntity("o235ye24", "Moskvich");
        ArrayList<CarEntity> list = new ArrayList<>();
        list.add(carEntity1);
        list.add(carEntity2);
        list.add(carEntity3);
        list.add(carEntity4);
        list.add(carEntity5);
        list.add(carEntity6);
        list.add(carEntity7);
        list.add(carEntity8);
        list.add(carEntity9);
        list.add(carEntity10);
        list.add(carEntity11);
        list.add(carEntity12);
    }
}
