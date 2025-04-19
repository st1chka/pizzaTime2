package org.example.pizza.decorator;

public abstract class PizzaDecorator extends Pizza {

  public Pizza decoratedPizza;

  public PizzaDecorator(Pizza pizza) {
    super(pizza.size);
    this.decoratedPizza = pizza;
  }

  @Override
  public abstract double calculatePrice();

  @Override
  public abstract String getName();

}
