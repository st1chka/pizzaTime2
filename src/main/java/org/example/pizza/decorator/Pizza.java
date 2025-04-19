package org.example.pizza.decorator;

import org.example.kitchen.interfases.Product;
import org.example.pizza.Size;

/**
 * Абстрактный класс, представляющий базовую пиццу.
 */
public abstract class Pizza implements Product {

  protected String name;
  protected Size size;
  protected double basePrice;


  /**
   * Конструктор базовой пиццы.
   *
   * @param size размер пиццы
   */
  public Pizza(Size size) {
    this.size = size;
  }

  /**
   * Рассчитывает итоговую стоимость пиццы с учетом размера.
   *
   * @return стоимость пиццы
   */
  @Override
  public double calculatePrice() {
    return basePrice * size.getMultiplier();
  }

  /**
   * @return название пиццы с размером
   */
  public String getName() {
    return name + " (" + size + ")";
  }


}
