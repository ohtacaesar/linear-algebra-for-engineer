package com.ohtacaesar.study.linear_algebra_for_engineer;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

  @Test
  public void testGcd() {
    Assert.assertEquals(3, Util.gcd(24, 9));
    Assert.assertEquals(4, Util.gcd(4, 4));
    Assert.assertEquals(1, Util.gcd(7, 2));
    Assert.assertEquals(3, Util.gcd(0, 3));
  }

  @Test
  public void testLcm() {
    Assert.assertEquals(72, Util.lcm(24, 9));
  }

}
