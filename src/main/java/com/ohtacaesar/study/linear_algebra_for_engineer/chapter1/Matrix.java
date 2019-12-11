package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class Matrix {

  public static Matrix of(int m, int n, RealNumber[] realNumbers) {
    return new Matrix(m, n, realNumbers);
  }

  public static Matrix random(int m, int n) {
    return new Matrix(m, n, RealNumber.randomArray(m * n));
  }

  public static Matrix zero(int m, int n) {
    return new Matrix(m, n, RealNumber.zeroArray(m * n));
  }

  public static Matrix identityMatrixOf(int m) {
    RealNumber zero = RealNumber.of(0);
    RealNumber one = RealNumber.of(1);
    RealNumber[] array = new RealNumber[m * m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        array[i * m + j] = i == j ? one : zero;
      }
    }

    return Matrix.of(m, m, array);
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

  /**
   * 正方行列
   */
  public boolean isSquareMatrix() {
    return this.m == this.n;
  }

  /**
   * 行列式
   * 正方行列に対して定義される量で、一次方程式の可読性を判定する指標として導入された
   */
  public RealNumber determinant() {
    assert this.m == 2;
    assert this.n == 2;
    RealNumber a = this.item(1, 1);
    RealNumber b = this.item(1, 2);
    RealNumber c = this.item(2, 1);
    RealNumber d = this.item(2, 2);
    return a.multiply(d).subtract(b.multiply(c));
  }

  /**
   * 正則行列
   * 逆行列が存在する行列
   */
  public boolean isRegularMatrix() {
    return !this.determinant().equals(RealNumber.of(0));
  }

  /**
   * 逆行列
   */
  public Matrix inverse() {
    assert this.m == 2;
    assert this.n == 2;
    RealNumber determinant = this.determinant();
    assert !determinant.equals(RealNumber.of(0));

    RealNumber a = this.item(1, 1);
    RealNumber b = this.item(1, 2);
    RealNumber c = this.item(2, 1);
    RealNumber d = this.item(2, 2);

    return Matrix.of(2, 2, new RealNumber[]{d, b.minus(), c.minus(), a}).multiply(
        RealNumber.of(1).divide(determinant)
    );
  }

}
