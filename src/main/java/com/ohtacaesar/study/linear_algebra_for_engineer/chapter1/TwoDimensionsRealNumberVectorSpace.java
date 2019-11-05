package com.ohtacaesar.study.linear_algebra_for_engineer.chapter1;

import com.ohtacaesar.study.linear_algebra_for_engineer.RealNumber;
import lombok.Value;

/**
 * 2次元の実数ベクトル空間
 */
public class TwoDimensionsRealNumberVectorSpace {


  /**
   * 実数ベクトル
   */
  @Value
  public static class RealNumberVector {

    public static RealNumberVector random() {
      return new RealNumberVector(RealNumber.random(), RealNumber.random());
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
  }
}
