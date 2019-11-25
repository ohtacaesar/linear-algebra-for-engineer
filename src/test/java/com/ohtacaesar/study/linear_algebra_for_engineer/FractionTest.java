package com.ohtacaesar.study.linear_algebra_for_engineer;

import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

  @Test
  public void testConstructor() {
    Fraction f;
    f = Fraction.of(1, 1);
    Assert.assertEquals(1, f.getNumerator());
    Assert.assertEquals(1, f.getDenominator());

    f = Fraction.of(2, 4);
    Assert.assertEquals(1, f.getNumerator());
    Assert.assertEquals(2, f.getDenominator());
  }

  @Test
  public void testAdd() {
    Fraction a = Fraction.of(3, 4);
    Fraction b = Fraction.of(1, 4);

    Assert.assertEquals(Fraction.of(1, 1), a.add(b));
  }

  @Test
  public void testSubtract() {
    Fraction a = Fraction.of(3, 4);
    Fraction b = Fraction.of(1, 4);

    Assert.assertEquals(Fraction.of(1, 2), a.subtract(b));
  }

  @Test
  public void testMultiply() {
    Fraction a = Fraction.of(3, 4);
    Fraction b = Fraction.of(1, 4);

    Assert.assertEquals(Fraction.of(3, 16), a.multiply(b));
  }

  @Test
  public void testDivide() {
    Fraction a = Fraction.of(3, 4);
    Fraction b = Fraction.of(1, 4);

    Assert.assertEquals(Fraction.of(3, 1), a.divide(b));
  }

  @Test
  public void testMinus() {
    Fraction a = Fraction.of(3, 4);

    Assert.assertEquals(Fraction.of(-3, 4), a.minus());
  }

  @Test
  public void testArrayOf() {
    Fraction[] a = Fraction.arrayOf(3, 2);

    Assert.assertEquals(Fraction.of(3, 1), a[0]);
    Assert.assertEquals(Fraction.of(2, 1), a[1]);
  }

}
