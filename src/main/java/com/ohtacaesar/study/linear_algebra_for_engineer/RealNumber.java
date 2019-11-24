package com.ohtacaesar.study.linear_algebra_for_engineer;

import java.util.Random;
import lombok.Value;

/**
 *  実数
 *  ==
 *
 *  実数の種類
 *  --
 *
 *  - 実数
 *    - 有理数
 *      - 整数
 *        - 自然数
 *        - 0
 *        - 負の整数
 *      - 整数でない有理数
 *        - 有限小数
 *        - 循環小数
 *    - 無理数
 *      - 超越数でない無理数
 *      - 超越数
 *
 *  メモ
 *  --
 *
 *  - Real NumberなのでRで表現するらしい
 */
@Value(staticConstructor = "of")
public class RealNumber {

  public static RealNumber random() {
    Random random = new Random();
    return new RealNumber(random.nextInt(1000));
  }

  public static RealNumber[] randomArray(int n) {
    RealNumber[] array = new RealNumber[n];
    for (int i = 0; i < n; i++) {
      array[i] = RealNumber.random();
    }
    return array;
  }

  public static RealNumber[] arrayOf(double... array) {
    RealNumber[] newArray = new RealNumber[array.length];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = RealNumber.of(array[i]);
    }
    return newArray;
  }

  public static RealNumber[] zeroArray(int n) {
    RealNumber[] array = new RealNumber[n];
    for (int i = 0; i < n; i++) {
      array[i] = RealNumber.of(0);
    }

    return array;
  }

  private double value;

  public RealNumber add(RealNumber r) {
    return new RealNumber(this.getValue() + r.getValue());
  }

  public RealNumber subtract(RealNumber r) {
    return new RealNumber(this.getValue() - r.getValue());
  }

  public RealNumber multiply(RealNumber r) {
    return new RealNumber(this.getValue() * r.getValue());
  }

  public RealNumber divide(RealNumber r) {
    return new RealNumber(this.getValue() / r.getValue());
  }

  public RealNumber minus() {
    return new RealNumber(-this.getValue());
  }

}
