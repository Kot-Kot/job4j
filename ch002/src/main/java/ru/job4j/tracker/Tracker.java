package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
     /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    //private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        //items[this.position++] = item;
        return item;
    }

    /**
     * Метод удаляет заявку по названию
     * @param id идентификатор заявки
     * @return Массив удаленных item
     */
    public Item delete(String id) {
        Item deletedItem = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                deletedItem = items.get(i);
                items.remove(i);
                break;
            }
        }
        return deletedItem;
    }

    /**
     * Метод изменяет название заявки
     * @param id id заявки
     * @param newName новое имя заявки
     * @return True - заявка удалена, false - заявка не найдена
     */
    public boolean replace(String id, String newName) {
        boolean isReplaced = false;
        int replacementCount = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                isReplaced = true;
                items.get(i).setName(newName);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод для получения списка всех заявок по определенному имени.
     * @return Список заявок по имени (без null).
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsByName = new ArrayList<>();
        int size = 0;
        for (int index = 0; index < this.items.size(); index++) {
            Item item = this.items.get(index);
            if (item != null && item.getName().equals(key)) {
                itemsByName.add(item);
                size++;
            }
        }
        return itemsByName;
    }

    /**
     * Метод для получения заявки по определенному id.
     * @return Заявка по id.
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.items.size(); index++) {
            Item item = this.items.get(index);
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