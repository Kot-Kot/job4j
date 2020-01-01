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
                for (int i = 0; i < itemList.length; i++) {
                    System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter item's name for changing: ");
                String oldName = scanner.nextLine();
                System.out.println("Enter item's new name: ");
                String newName = scanner.nextLine();
                if (tracker.replace(oldName, newName)) {
                    System.out.println("Item(s) has been edited");
                } else {
                    System.out.println("Needed item was not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item by Id ====");
                System.out.println("Enter item's Id for deleting: ");
                String id = scanner.nextLine();
                Item deletedItem = tracker.delete(id);
                if (deletedItem != null) {
                    System.out.println("Item has been deleted");
                } else {
                    System.out.println("Item has not found");
                }

            } else if (select == 4) {
                System.out.println("===  Find item by Id ====");
                System.out.println("Enter item's Id to search: ");
                String id = scanner.nextLine();
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Item has not found");
                } else {
                    System.out.println(item.getId() + " : " + item.getName());
                }
            } else if (select == 5) {
                System.out.println("===   Find items by name ====");
                System.out.println("Enter item's name to search: ");
                String name = scanner.nextLine();
                Item[] itemList = tracker.findByName(name);
                for (int i = 0; i < itemList.length; i++) {
                    if (itemList[i] != null) {
                        System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
                    }
                }
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
        tracker.add(new Item("i1"));
        tracker.add(new Item("i2"));
        tracker.add(new Item("i3"));
        tracker.add(new Item("i5"));
        tracker.add(new Item("i1"));
        new StartUI().init(scanner, tracker);
    }
}