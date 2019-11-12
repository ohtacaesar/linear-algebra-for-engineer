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
@Value
public class RealNumber {

  public static RealNumber random() {
    Random random = new Random();
    return new RealNumber(random.nextInt(1000));
  }

  private double value;

  public RealNumber add(RealNumber n) {
    return new RealNumber(this.getValue() + n.getValue());
  }

  public RealNumber multiply(RealNumber n) {
    return new RealNumber(this.getValue() * n.getValue());
  }

  public RealNumber minus() {
    return new RealNumber(-this.getValue());
  }

}
