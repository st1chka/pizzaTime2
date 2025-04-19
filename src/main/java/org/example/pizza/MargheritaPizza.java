package org.example.pizza;

import org.example.pizza.decorator.Pizza;

//Реализация маргариты,
public class MargheritaPizza extends Pizza {

  public MargheritaPizza(Size size) {
    super(size);
    this.name = "Маргаритта";
    this.basePrice = 500.0;
  }

}
