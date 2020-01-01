package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        System.out.println("Удаляемый элемент : " + index + ", " + products[index].getName());
        products[index] = null;
        for (int i = index + 1; i < products.length - 1; i++) {
            if (products[i] != null) {
                products[i - 1] = products[i];
                products[i] = null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Apple", 100);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Проверка методе Delete");
        new Shop().delete(products, 2);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }



    }
}