package com.Calculators;

public class CalculateContext {

  private CalculateStrategy calculateStrategy;

  public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
    this.calculateStrategy = calculateStrategy;
  }

  public double calculateScore(String text) {
    return this.calculateStrategy.calculateScore(text);
  }
}
