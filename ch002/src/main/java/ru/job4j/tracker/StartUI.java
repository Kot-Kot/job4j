package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }


    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validateInput = new ValidateInput(input);
        Tracker tracker = new Tracker();
        tracker.add(new Item("i1"));
        tracker.add(new Item("i2"));
        tracker.add(new Item("i3"));
        tracker.add(new Item("i2"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ShowAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindItemByIdAction());
        actions.add(new FindItemByNameAction());
        new StartUI().init(validateInput, tracker, actions);
    }
}