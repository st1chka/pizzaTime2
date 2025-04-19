package org.example;

import org.example.customer.Customer;
import org.example.kitchen.customException.KitchenOverloadException;
import org.example.kitchen.interfases.Kitchen;
import org.example.kitchen.realizations.PizzaKitchen;
import org.example.pizza.MargheritaPizza;
import org.example.pizza.Size;
import org.example.pizza.decorator.CheeseDecorator;

public class Main {

  public static void main(String[] args) {
    Kitchen pizzaKitchen = new PizzaKitchen(1); // Лимит кухни: 1 заказ
    //создаем пользователя и корзину
    Customer vasya = new Customer("Вася");
    vasya.createOrder();
    //добавляем пиццу в заказ
    vasya.addPizzaToOrder(new MargheritaPizza(Size.MEDIUM));
    vasya.addPizzaToOrder(new CheeseDecorator(new MargheritaPizza(Size.LARGE)));

    try {
      //Подтверждаем заказ
      var vasyaOrder = vasya.confirmOrder();
      //Отправляем заказ на кухню
      pizzaKitchen.prepareOrder(vasyaOrder);
    } catch (KitchenOverloadException e) {
      System.out.println("Error: " + e.getMessage());
    }

    //Если не убрать аню, упадет ошибка
    Customer anya = new Customer("Аня");
    anya.createOrder();
    anya.addPizzaToOrder(new MargheritaPizza(Size.SMALL));

    try {
      var anyaOrder = anya.confirmOrder();
      pizzaKitchen.prepareOrder(anyaOrder);
    } catch (KitchenOverloadException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void getMenu(){
    /**
     * Вообще, без бд не хотелось бы реализовывать такой функционал, ибо можно просто вызвать
     * метод по типу getAllPizza(){
     * который полезет в репозиторий pizzaRepository{
     *    List<Pizza> findAll();
     *  }
     *  или любой другой репозиторий
     * }
     * в сервисе мы всё это склеем в List<ProductDTO> и вернем по ручке которую запросили
     */
  }
}