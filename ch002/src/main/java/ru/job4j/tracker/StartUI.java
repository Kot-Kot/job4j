package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemByNameAction()
        };
        new StartUI().init(input, tracker, actions);
    }

    /*public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== List of all items ====");
        Item[] itemList = tracker.findAll();
        for (int i = 0; i < itemList.length; i++) {
            System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter item's id for changing: ");
        String newName = input.askStr("Enter item's new name: ");
        if (tracker.replace(id, newName)) {
            System.out.println("Item(s) has been edited");
        } else {
            System.out.println("Needed item was not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item by Id ====");
        String id = input.askStr("Enter item's Id for deleting: ");
        Item deletedItem = tracker.delete(id);
        if (deletedItem != null) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Item has not found");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("===  Find item by Id ====");
        String id = input.askStr("Enter item's Id to search: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item has not found");
        } else {
            System.out.println(item.getId() + " : " + item.getName());
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("===   Find items by name ====");
        String name = input.askStr("Enter item's name to search: ");
        Item[] itemList = tracker.findByName(name);
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] != null) {
                System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("i1"));
        tracker.add(new Item("i2"));
        tracker.add(new Item("i3"));
        tracker.add(new Item("i5"));
        tracker.add(new Item("i1"));
        new StartUI().init(input, tracker);
    } */
}