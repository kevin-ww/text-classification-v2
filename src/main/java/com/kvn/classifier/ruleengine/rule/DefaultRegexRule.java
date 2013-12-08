package com.kvn.classifier.ruleengine.rule;

import com.kvn.classifier.common.ProductReview;

public abstract class DefaultRegexRule extends RegexRule<ProductReview> {

  public DefaultRegexRule(String name) {
    super(name);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  public boolean eval(ProductReview input) {
    return super.isMatch(input.getReviewText());
  }

  

}
