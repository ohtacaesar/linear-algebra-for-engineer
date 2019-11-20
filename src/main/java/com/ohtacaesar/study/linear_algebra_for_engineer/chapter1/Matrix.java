package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;

public class Matrix {

  public static Matrix of(int m, int n, RealNumber[] realNumberArray) {
    return new Matrix(m, n, realNumberArray);
  }

  // 行
  public final int m;
  // 列
  public final int n;

  private final RealNumber[] realNumberArray;


  private Matrix(int m, int n, RealNumber[] realNumberArray) {
    assert m * n == realNumberArray.length;
    this.m = m;
    this.n = n;
    this.realNumberArray = realNumberArray.clone();
  }

  public RealNumber item(int i, int j) {
    assert i > 0;
    assert i <= m;
    assert j > 0;
    assert j <= n;

    return realNumberArray[(i - 1) * n + (j - 1)];
  }

  /**
   * 転置
   */
  public Matrix transpose() {
    RealNumber[] newArray = new RealNumber[realNumberArray.length];
    for (int i = 0; i < realNumberArray.length; i++) {
      newArray[i % n * m + i / n] = realNumberArray[i];
    }
    return Matrix.of(n, m, newArray);
  }

}
