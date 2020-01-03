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
     * @param id идентификатор заявки
     * @return Массив удаленных item
     */
    public Item delete(String id) {
        Item deletedItem = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                deletedItem = items[i];
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, position - i);
                break;
            }
        }
        position--;
        return deletedItem;
    }

    /**
     * Метод изменяет название заявки
     * @param oldName старое имя заявки
     * @param newName новое имя заявки
     * @return True - заявка удалена, false - заявка не найдена
     */
    public boolean replace(String oldName, String newName) {
        boolean isReplaced = false;
        int replacementCount = 0;
        Item[] activeItems = items;
        for (int i = 0; i < position; i++) {
            if (activeItems[i].getName().equals(oldName)) {
                isReplaced = true;
                activeItems[i].setName(newName);
            }
        }
        return isReplaced;
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
            }
        }
    }



}