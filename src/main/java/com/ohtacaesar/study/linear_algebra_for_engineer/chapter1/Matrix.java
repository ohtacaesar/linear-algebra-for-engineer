package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class Matrix {

  public static Matrix of(int m, int n, RealNumber[] realNumberArray) {
    return new Matrix(m, n, realNumberArray);
  }

  public static Matrix random(int m, int n) {
    return new Matrix(m, n, RealNumber.randomArray(m * n));
  }

  // 行
  public final int m;
  // 列
  public final int n;

  @Getter(value = AccessLevel.NONE)
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

  public Matrix multiply(RealNumber scalar) {
    RealNumber[] newArray = this.realNumberArray.clone();
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = newArray[i].multiply(scalar);
    }

    return Matrix.of(this.m, this.n, newArray);
  }

  public Matrix add(Matrix matrix) {
    assert this.m == matrix.m;
    assert this.n == matrix.n;

    RealNumber[] newArray = new RealNumber[this.realNumberArray.length];
    for (int i = 0; i < this.realNumberArray.length; i++) {
      newArray[i] = this.realNumberArray[i].add(matrix.realNumberArray[i]);
    }

    return Matrix.of(this.m, this.n, newArray);
  }

  public Matrix multiply(Matrix matrix) {
    assert this.n == matrix.m;
    int size = this.m * matrix.n;
    RealNumber[] newArray = new RealNumber[size];

    for (int i = 0; i < this.m; i++) {
      for (int k = 0; k < matrix.n; k++) {
        RealNumber r = RealNumber.of(0);
        for (int j = 0; j < this.n; j++) {
          r = r.add(
              this.realNumberArray[i * this.n + j].multiply(
                  matrix.realNumberArray[j * matrix.n + k]));
        }
        newArray[i * matrix.n + k] = r;
      }
    }

    return Matrix.of(this.m, matrix.n, newArray);
  }

}
