package ru.job4j.tracker;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("Tiger's constructor");
    }

    public static void main(String[] args) {
        new Tiger();
        System.out.println();
        new Predator();
        System.out.println();
        new Animal();
    }
}
