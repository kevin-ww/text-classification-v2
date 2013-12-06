package com.kvn.classifier.ruleengine.rule;

import com.kvn.classifier.common.ProductReview;

public class LogisiticsRule extends BaseClassifierRule<ProductReview> {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final String TAG = "Logisitics";

  public LogisiticsRule(String name) {
    super(name);

  }

  @Override
  public String toString() {
    return "LogisiticsRule [name=" + getName() + "]";
  }

  @Override
  public boolean eval(ProductReview input) {
    // TODO Auto-generated method stub
    return false;
  }



}
