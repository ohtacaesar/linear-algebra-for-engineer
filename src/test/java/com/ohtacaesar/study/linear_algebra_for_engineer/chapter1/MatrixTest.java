package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

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
}
