package org.example.customer;

import org.example.kitchen.interfases.Product;
import org.example.kitchen.interfases.Kitchen;
import org.example.kitchen.customException.KitchenOverloadException;
import org.example.order.Order;


/**
 * Класс, представляющий клиента пиццерии.
 */
public class Customer {

  private final String name;
  private Order currentOrder;

  /**
   * Создает клиента с указанным именем.
   *
   * @param name имя клиента
   */
  public Customer(String name) {
    this.name = name;
  }

  /**
   * Создает новый заказ.
   */
  public void createOrder() {
    currentOrder = new Order();
  }

  /**
   * Добавляет пиццу в текущий заказ.
   *
   * @param product продукт для добавления
   * @throws IllegalStateException если заказ не был создан
   */
  public void addPizzaToOrder(Product product) {
    if (currentOrder == null) {
      throw new IllegalStateException("Заказ не создан");
    }
    currentOrder.addProduct(product);
  }

  /**
   * Подтверждает заказ и отправляет его на кухню.
   *
   * @return currentOrder подтвержденный заказ
   * @throws KitchenOverloadException если кухня перегружена
   * @throws IllegalStateException    если заказ пустой
   */
  public Order confirmOrder() throws KitchenOverloadException {
    if (currentOrder == null || currentOrder.getProducts().isEmpty()) {
      throw new IllegalStateException("Заказ пуст");
    }
    System.out.println("Пользователь " + name + " подтвердил заказ");
    return currentOrder;
  }
}
