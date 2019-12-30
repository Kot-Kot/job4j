package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    //добавление заявок - public Item add(Item item);
    //получение списка всех заявок - public Item[] findAll();
    //получение списка по имени - public Item[] findByName(String key);
    //получение заявки по id - public Item findById(String id);

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }


    /**
     * Метод для получения списка всех заявок.
     * @return Список заявок.
     */
    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item name = this.items[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        //namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int index = 0; index < namesWithoutNull.length; index++) {
            System.out.println(namesWithoutNull[index]);
        }
        return new Item[10];
    }


}