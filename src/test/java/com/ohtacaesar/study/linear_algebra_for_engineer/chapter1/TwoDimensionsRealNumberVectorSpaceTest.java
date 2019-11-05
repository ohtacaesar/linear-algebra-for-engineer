package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import com.ohtacaesar.study.linear_algebra_for_engineer.chapter1.TwoDimensionsRealNumberVectorSpace.RealNumberVector;
import org.junit.Assert;
import org.junit.Test;


public class TwoDimensionsRealNumberVectorSpaceTest {

  public static class RealNumberVectorTest {

    @Test
    public void testEquals() {
      RealNumberVector rnv = new RealNumberVector(new RealNumber(1), new RealNumber(99));
      Assert.assertEquals(rnv, rnv);
      Assert.assertEquals(rnv, new RealNumberVector(new RealNumber(1), new RealNumber(99)));
      Assert.assertNotEquals(rnv, new RealNumberVector(new RealNumber(1), new RealNumber(100)));
    }
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

}
