package ru.job4j.tracker;

import java.lang.reflect.Array;
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
     * Метод удаляет заявку по названию
     * @return Массив удаленных item
     */
    public Item[] delete(String name) {
        Item[] result;
        int count = 0;
        Item[] deletedItems = new Item[position];
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(name)) {
                deletedItems[count] = items[i];
                count++;
                items[i] = null;
                for (int j = i + 1; j < position; j++) {
                    items[j - 1] = items[j];
                    items[j] = null;
                }
            }
        }
        if (count == 0) {
            result = null;
        } else {
          result = Arrays.copyOf(deletedItems, count);
        }
        position -= count;
        return result;
    }

    /**
     * Метод изменяет название заявки
     */
    public void replaceName(String name, int pos) {
        items[pos].setName(name);
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random r = new Random();
        return String.valueOf(System.currentTimeMillis() + r.nextInt());
    }


    /**
     * Метод для получения списка всех заявок.
     * @return Список всех заявок (исключая null).
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
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
            if (item != null && item.getId().equals(id)) {
                result = item;
                System.out.println(result.getId() + " : " + result.getName());
                break;
            }
        }
        return result;
    }
    /**
     * Метод для вывода в консоль элементов массива Item[].
     */
    public void print(Item[] itemList) {
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] != null) {
                System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
            } else {
                System.out.println(i + " element is NULL");
            }
        }
    }



}