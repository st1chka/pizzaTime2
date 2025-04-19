package org.example.pizza.decorator;

import org.example.kitchen.interfases.Product;

public class CheeseDecorator extends PizzaDecorator implements Product {

  public CheeseDecorator(Pizza pizza) {
    super(pizza);
  }

  @Override
  public double calculatePrice() {
    return decoratedPizza.calculatePrice() + 50.0;
  }

  @Override
  public String getName() {
    return decoratedPizza.getName() + " больше сыра";
  }
}
