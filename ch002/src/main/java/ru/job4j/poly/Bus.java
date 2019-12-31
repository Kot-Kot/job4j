package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        boolean isDrive = false;
    }

    @Override
    public void passengers(int count) {
        int weight = count * 70;
    }

    @Override
    public int fillCost(int fuel) {
        int cost = fuel * 100;
        return cost;
    }
}
