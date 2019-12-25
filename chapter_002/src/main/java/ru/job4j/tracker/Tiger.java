package ru.job4j.tracker;

public class Tiger extends Predator {
    public Tiger(String name) {
        super(name);
        System.out.println("Tiger's constructor");
    }

    public static void main(String[] args) {
        new Tiger("name");
        System.out.println();
        new Predator("name");
        System.out.println();
        new Animal("name");
    }
}
