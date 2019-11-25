package com.ohtacaesar.study.linear_algebra_for_engineer;

import java.util.Random;
import lombok.Value;

@Value
public class Fraction {

  public static Fraction of(int numerator, int denominator) {
    return new Fraction(numerator, denominator);
  }

  public static Fraction of(int numerator) {
    return Fraction.of(numerator, 1);
  }

  public static Fraction random() {
    Random random = new Random();
    return Fraction.of(random.nextInt(200));
  }

  public static Fraction[] randomArray(int n) {
    Fraction[] array = new Fraction[n];
    for (int i = 0; i < n; i++) {
      array[i] = random();
    }
    return array;
  }

  public static Fraction[] arrayOf(int... array) {
    Fraction[] fractionArray = new Fraction[array.length];
    for (int i = 0; i < array.length; i++) {
      fractionArray[i] = Fraction.of(array[i], 1);
    }

    return fractionArray;
  }

  public static Fraction[] zeroArray(int n) {
    Fraction[] fractionArray = new Fraction[n];
    for (int i = 0; i < n; i++) {
      fractionArray[i] = Fraction.of(0, 1);
    }

    return fractionArray;
  }


  private int numerator;
  private int denominator;

  private Fraction(int numerator, int denominator) {
    int lcd = Util.gcd(numerator, denominator);
    this.numerator = numerator / lcd;
    this.denominator = denominator / lcd;
    assert this.denominator > 0;
  }


  public Fraction add(Fraction f) {
    int lcm = Util.lcm(this.getDenominator(), f.getDenominator());
    int a = this.numerator * (lcm / this.denominator);
    int b = f.getNumerator() * (lcm / f.getDenominator());

    return Fraction.of(a + b, lcm);
  }

  public Fraction subtract(Fraction f) {
    int lcm = Util.lcm(this.getDenominator(), f.getDenominator());
    int a = this.numerator * (lcm / this.denominator);
    int b = f.getNumerator() * (lcm / f.getDenominator());

    return Fraction.of(a - b, lcm);
  }

  public Fraction multiply(Fraction f) {
    return Fraction.of(
        this.getNumerator() * f.getNumerator(),
        this.getDenominator() * f.getDenominator()
    );
  }

  public Fraction divide(Fraction f) {
    return Fraction.of(
        this.getNumerator() * f.getDenominator(),
        this.getDenominator() * f.getNumerator()
    );
  }

  public Fraction minus() {
    return Fraction.of(-this.getNumerator(), this.getDenominator());
  }

}
