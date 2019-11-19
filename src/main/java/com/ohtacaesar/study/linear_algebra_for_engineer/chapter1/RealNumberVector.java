package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import lombok.Value;

@Value(staticConstructor = "of")
public class RealNumberVector {

  static final RealNumberVector ZERO = RealNumberVector.of(RealNumber.of(0), RealNumber.of(0));

  static final RealNumberVector Ex = RealNumberVector.of(RealNumber.of(1), RealNumber.of(0));

  static final RealNumberVector Ey = RealNumberVector.of(RealNumber.of(0), RealNumber.of(1));

  public static RealNumberVector random() {
    return RealNumberVector.of(RealNumber.random(), RealNumber.random());
  }

  public static RealNumberVector of(double x, double y) {
    return RealNumberVector.of(RealNumber.of(x), RealNumber.of(y));
  }

  // 英語でなんて言う?(x, y)?
  private RealNumber 第一成分;
  private RealNumber 第二成分;

  /**
   * 実数倍
   */
  public RealNumberVector multiply(RealNumber n) {

    return RealNumberVector.of(
        this.get第一成分().multiply(n),
        this.get第二成分().multiply(n)
    );
  }

  /**
   * 加法
   */
  public RealNumberVector add(RealNumberVector v) {
    return RealNumberVector.of(
        this.get第一成分().add(v.get第一成分()),
        this.get第二成分().add(v.get第二成分())
    );
  }

  /**
   * 和の逆元
   */
  public RealNumberVector inverse() {
    return this.multiply(RealNumber.of(-1));
  }

  /**
   * @param e1 標準基底の変換先
   * @param e2 標準基底の変換先
   * @return
   */
  public RealNumberVector linearTransform(RealNumberVector e1, RealNumberVector e2) {
    return e1.multiply(this.第一成分).add(e2.multiply(第二成分));
  }
}
