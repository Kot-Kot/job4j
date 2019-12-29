package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
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
     * @return Список всех заявок (исключая null).
     */
    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item item = this.items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        for (int index = 0; index < itemsWithoutNull.length; index++) {
            System.out.println(itemsWithoutNull[index]);
        }
        return itemsWithoutNull;
    }

    /**
     * Метод для получения списка всех заявок по определенному имени.
     * @return Список заявок по имени (без null).
     */
    public Item[] findByName(String key) {
        Item[] itemsByName = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item item = this.items[index];
            if (item != null && item.getName().equals(key)) {
                itemsByName[size] = item;
                size++;
            }
        }
        itemsByName = Arrays.copyOf(itemsByName, size);
        for (int index = 0; index < itemsByName.length; index++) {
            System.out.println(itemsByName[index]);
        }
        return itemsByName;
    }

    /**
     * Метод для получения заявки по определенному id.
     * @return Заявка по id.
     */
    public Item findById(String id) {
        Item result = null;
        //int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item item = this.items[index];
            if (item.getId().equals(id)) {
                result = item;
                System.out.println(result.getId() + " : " + result.getName());
                break;
            }
        }
        return result;
    }



}