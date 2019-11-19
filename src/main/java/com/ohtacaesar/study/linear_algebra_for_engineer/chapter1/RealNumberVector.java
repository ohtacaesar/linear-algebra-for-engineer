package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import lombok.Value;

@Value(staticConstructor = "of")
public class RealNumberVector {

  static final RealNumberVector ZERO = new RealNumberVector(RealNumber.of(0), RealNumber.of(0));

  static final RealNumberVector Ex = new RealNumberVector(RealNumber.of(1), RealNumber.of(0));

  static final RealNumberVector Ey = new RealNumberVector(RealNumber.of(0), RealNumber.of(1));

  public static RealNumberVector random() {
    return RealNumberVector.of(RealNumber.random(), RealNumber.random());
  }

  // 英語でなんて言う?(x, y)?
  private RealNumber 第一成分;
  private RealNumber 第二成分;

  /**
   * 実数倍
   */
  public RealNumberVector multiply(RealNumber n) {

    return new RealNumberVector(
        this.get第一成分().multiply(n),
        this.get第二成分().multiply(n)
    );
  }

  /**
   * 加法
   */
  public RealNumberVector add(RealNumberVector v) {
    return new RealNumberVector(
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
}
