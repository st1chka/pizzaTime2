package org.example.kitchen.realizations;

import org.example.kitchen.interfases.Product;
import org.example.kitchen.customException.KitchenOverloadException;
import org.example.kitchen.interfases.Kitchen;
import org.example.order.Order;
import org.example.pizza.decorator.Pizza;

/**
 * Реализация кухни для приготовления пицц с ограничением на количество заказов.
 */
public class PizzaKitchen implements Kitchen {

  private final int maxOrders;
  private int currentOrders = 0;

  /**
   * Создает кухню с указанным лимитом заказов.
   *
   * @param maxOrders максимальное количество одновременных заказов
   */
  public PizzaKitchen(int maxOrders) {
    this.maxOrders = maxOrders;
  }

  @Override
  public void prepareOrder(Order order) throws KitchenOverloadException {
    if (currentOrders >= maxOrders) {
      throw new KitchenOverloadException(
          "Кухня устала делать заказы, надо пойти на перекур, заказов выполнено: " + maxOrders);
    }
    currentOrders++;

    System.out.println("Приготовление заказа " + order.getProducts().size() + " единицы :");

    for (Product product : order.getProducts()) {
      if (product instanceof Pizza) {
        /**
         * Имитация приготовление чтоб sout не пролетал быстро
         */
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          throw new RuntimeException("Ошибка сна потока");
        }

        System.out.println(
            "- " + ((Pizza) product).getName() + ": " + product.calculatePrice() + " руб.");
      }
    }
    System.out.println("Итоговая цена : " + order.calculateTotalPrice() + " руб.");

  }
}