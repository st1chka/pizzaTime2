package org.example.order;

import java.util.ArrayList;
import java.util.List;
import org.example.kitchen.interfases.Product;

public class Order {

  private final List<Product> products = new ArrayList<>();

  /**
   * Добавляет пиццу в заказ.
   *
   * @param product продукт для добавления
   */
  public void addProduct(Product product) {
    products.add(product);
  }

  /**
   * Расчитывает стоимость заказа.
   *
   * @return суммарная стоимость всего заказа
   */
  public double calculateTotalPrice() {
    return products.stream().mapToDouble(Product::calculatePrice).sum();
  }

  /**
   * Возвращает продукты которые были добавлены
   *
   * @return суммарная стоимость всего заказа
   */
  public List<Product> getProducts() {
    return new ArrayList<>(products);
  }
}
