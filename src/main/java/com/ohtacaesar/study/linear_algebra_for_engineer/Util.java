package com.ohtacaesar.study.linear_algebra_for_engineer;

public class Util {

  public static int gcd(int x, int y) {
    while (y > 0) {
      int mod = x % y;
      x = y;
      y = mod;
    }

    return x;
  }

  public static int lcm(int x, int y) {
    return x * y / gcd(x, y);
  }

}
