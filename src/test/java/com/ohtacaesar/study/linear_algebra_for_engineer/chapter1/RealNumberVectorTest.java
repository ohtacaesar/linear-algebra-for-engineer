package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://en.wikipedia.org/wiki/Vector_space#Definition
 */
public class RealNumberVectorTest {

  @Test
  public void testEquals() {
    RealNumberVector rnv = RealNumberVector.of(RealNumber.of(1), RealNumber.of(99));
    Assert.assertEquals(rnv, rnv);
    Assert.assertEquals(rnv, RealNumberVector.of(RealNumber.of(1), RealNumber.of(99)));
    Assert.assertNotEquals(rnv, RealNumberVector.of(RealNumber.of(1), RealNumber.of(100)));
  }

  /**
   * 2. 任意のa, b, c ∈ R2について、(a + b) + c = a + (b + c)が成り立つ。
   */
  @Test
  public void associativityOfAddition() {
    RealNumberVector u = RealNumberVector.random();
    RealNumberVector v = RealNumberVector.random();
    RealNumberVector w = RealNumberVector.random();

    Assert.assertEquals(u.add(v.add(w)), u.add(v).add(w));
  }

  /**
   * 1. 任意のa, b ∈ R2について、a + b = b + aが成り立つ。
   */
  @Test
  public void commutativityOfAddition() {
    RealNumberVector u = RealNumberVector.random();
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(u.add(v), v.add(u));
  }

  /**
   * 3. ある0 ∈ R2が存在して、任意のa ∈ R2について、a + 0 = a が成り立つ。
   */
  @Test
  public void identityElementOfAddition() {
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(v.add(RealNumberVector.ZERO), v);
  }

  /**
   * 4. 任意のa∈ R2について、a + x = 0 を満たすx ∈ R2 がaに応じて存在する（0は、3.の性質を満たす要素）。
   */
  @Test
  public void inverseElementsOfAddition() {
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(v.add(v.inverse()), RealNumberVector.ZERO);
  }

  /**
   * 6. 任意のk, l ∈ R, a ∈ R2について、k・(l・a)＝( kl・a)が成り立つ。
   */
  @Test
  public void compatibilityOfScalarMultiplicationWithFieldMultiplication() {
    RealNumber a = RealNumber.random();
    RealNumber b = RealNumber.random();
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(v.multiply(b).multiply(a), v.multiply(a.multiply(b)));
  }

  /**
   * 5. 任意のa ∈ R2について、1・a = aが成り立つ。
   */
  @Test
  public void identityElementOfScalarMultiplication() {
    RealNumber one = RealNumber.of(1);
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(v.multiply(one), v);
  }

  /**
   * 8. 任意の k ∈ R, a, b ∈ R2について、k・( a + b) = k・a + k・b が 成り立つ。
   */
  @Test
  public void distributivityOfScalarMultiplicationWithRespectToVectorAddition() {
    RealNumber a = RealNumber.random();
    RealNumberVector u = RealNumberVector.random();
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(u.add(v).multiply(a), u.multiply(a).add(v.multiply(a)));
  }

  /**
   * 7. 任意の k, l ∈ R, a ∈ R 2 について、( k + l・a) = k・a + l・a が 成り立つ。
   */
  @Test
  public void distributivityOfScalarMultiplicationWithRespectToFieldAddition() {
    RealNumber a = RealNumber.random();
    RealNumber b = RealNumber.random();
    RealNumberVector v = RealNumberVector.random();

    Assert.assertEquals(v.multiply(a.add(b)), v.multiply(a).add(v.multiply(b)));
  }

  /**
   * 標準基底
   */
  @Test
  public void standardBasis() {
    RealNumber a = RealNumber.random();
    RealNumber b = RealNumber.random();
    RealNumberVector x = RealNumberVector.of(a, b);

    Assert.assertEquals(x, RealNumberVector.Ex.multiply(a).add(RealNumberVector.Ey.multiply(b)));
  }

}
