package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== List of all items ====");
                Item[] itemList = tracker.findAll();
                tracker.print(itemList);
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter item's name for changing: ");
                String name = scanner.nextLine();
                Item[] itemList = tracker.findAll();
                for (int i = 0; i < itemList.length; i++) {
                    if (itemList[i].getName().equals(name)) {
                        System.out.println("Enter new name for the item : " + itemList[i].getName());
                        String newName = scanner.nextLine();
                        itemList[i].setName(newName);
                        System.out.println("New name for the item : " + itemList[i].getName());
                    }
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter item's name for deleting: ");
                String name = scanner.nextLine();
                Item[] itemList = tracker.delete(name);
                tracker.print(itemList);
                System.out.println();
                tracker.print(tracker.findAll());
            } else if (select == 4) {
                System.out.println("===  Find item by Id ====");
                System.out.println("Enter item's Id to search: ");
                String id = scanner.nextLine();
                System.out.println("Item's name: " + tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("===   Find items by name ====");
                System.out.println("Enter item's name to search: ");
                String name = scanner.nextLine();
                Item[] itemList = tracker.findByName(name);
                tracker.print(itemList);

            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
     }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        tracker.add(new Item("item5"));
        tracker.add(new Item("item1"));
        new StartUI().init(scanner, tracker);
    }
}