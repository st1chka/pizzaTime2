package org.example.pizza;

/**
 * Перечисление размеров со множителем от базовой цены, базовая стоимость указывается за средний
 * размер
 */
public enum Size {
  SMALL(0.8),
  MEDIUM(1.0),
  LARGE(1.2);

  private final double multiplier;

  Size(double multiplier) {
    this.multiplier = multiplier;
  }

  public double getMultiplier() {
    return multiplier;
  }
}
