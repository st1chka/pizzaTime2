package org.example.kitchen.interfases;

import org.example.kitchen.customException.KitchenOverloadException;
import org.example.order.Order;

/**
 * Интерфейс для кухни, обрабатывающей заказы.
 */

public interface Kitchen {

  /**
   * Обрабатывает заказ.
   *
   * @param order заказ для приготовления
   * @throws KitchenOverloadException если достигнут лимит заказов
   */
  void prepareOrder(Order order) throws KitchenOverloadException;
}