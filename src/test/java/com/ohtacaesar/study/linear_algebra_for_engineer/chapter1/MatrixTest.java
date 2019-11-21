package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

  @Test
  public void testEquals() {
    Matrix a = Matrix.of(2, 3, RealNumber.arrayOf(1, 2, 3, 4, 5, 6));
    Matrix b = Matrix.of(2, 3, RealNumber.arrayOf(1, 2, 3, 4, 5, 6));
    Matrix c = Matrix.of(3, 2, RealNumber.arrayOf(1, 2, 3, 4, 5, 6));

    Assert.assertEquals(a, a);
    Assert.assertEquals(a, b);
    Assert.assertNotEquals(a, c);
  }

  @Test
  public void testOf() {
    Matrix matrix = Matrix.of(3, 2, RealNumber.randomArray(6));
    Assert.assertNotNull(matrix);
    Assert.assertEquals(3, matrix.m);
    Assert.assertEquals(2, matrix.n);
  }

  @Test(expected = AssertionError.class)
  public void testOfWithWrongSize() {
    Matrix.of(3, 2, RealNumber.randomArray(5));
  }

  @Test
  public void testItem() {
    RealNumber[] array = RealNumber.randomArray(8);
    Matrix matrix = Matrix.of(4, 2, array);
    Assert.assertEquals(array[0], matrix.item(1, 1));
    Assert.assertEquals(array[1], matrix.item(1, 2));
    Assert.assertEquals(array[2], matrix.item(2, 1));
    Assert.assertEquals(array[3], matrix.item(2, 2));
  }

  @Test
  public void testTranspose() {
    Matrix a = Matrix.of(4, 2, RealNumber.randomArray(8));
    Matrix b = a.transpose();

    Assert.assertEquals(a.m, b.n);
    Assert.assertEquals(a.n, b.m);
    Assert.assertEquals(a.item(1, 1), b.item(1, 1));
    Assert.assertEquals(a.item(2, 1), b.item(1, 2));
    Assert.assertEquals(a.item(3, 1), b.item(1, 3));
    Assert.assertEquals(a.item(4, 1), b.item(1, 4));
  }

  @Test
  public void testMultiplyWithScaler() {
    RealNumber k = RealNumber.random();
    Matrix a = Matrix.random(3, 2);
    Matrix b = a.multiply(k);

    for (int i = 1; i <= a.m; i++) {
      for (int j = 1; j <= a.n; j++) {
        Assert.assertEquals(b.item(i, j), a.item(i, j).multiply(k));
      }
    }
  }

  @Test
  public void testAdd() {
    Matrix a = Matrix.random(3, 2);
    Matrix b = a.add(a);

    for (int i = 1; i <= a.m; i++) {
      for (int j = 1; j <= a.n; j++) {
        Assert.assertEquals(b.item(i, j), a.item(i, j).multiply(RealNumber.of(2)));
      }
    }
  }

  @Test(expected = AssertionError.class)
  public void testAddWithDifferentSize() {
    Matrix a = Matrix.random(3, 2);
    Matrix b = Matrix.random(4, 2);

    a.add(b);
  }

  @Test
  public void testMultiplyWithMatrix() {
    Matrix a = Matrix.of(2, 2, RealNumber.arrayOf(1, 1, 2, 2));
    Matrix b = Matrix.of(2, 2, RealNumber.arrayOf(1, 2, 1, 2));
    Matrix ab = Matrix.of(2, 2, RealNumber.arrayOf(2, 4, 4, 8));
    Matrix ba = Matrix.of(2, 2, RealNumber.arrayOf(5, 5, 5, 5));
    Assert.assertEquals(ab, a.multiply(b));
    Assert.assertEquals(ba, b.multiply(a));

    a = Matrix.of(2, 6, RealNumber.randomArray(12));
    b = Matrix.of(6, 3, RealNumber.randomArray(18));
    Matrix c = a.multiply(b);
    Assert.assertEquals(a.m, c.m);
    Assert.assertEquals(b.n, c.n);
  }
}
