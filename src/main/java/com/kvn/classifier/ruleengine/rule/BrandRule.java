package com.kvn.classifier.ruleengine.rule;

public class BrandRule extends DefaultRegexRule {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final String LABEL = "Brand";

  public BrandRule() {
    this("brand_rule_without_name");
  }

  public BrandRule(String name) {
    super(name);
  }

  @Override
  public String getRuleLable() {
    return LABEL;
  }

}
